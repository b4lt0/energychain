
package com.group1.energymanager.service;

import com.group1.energymanager.DTOs.TransactionDTO;
import com.group1.energymanager.exceptions.PacketNotFoundException;
import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.model.Packet;
import com.group1.energymanager.model.Transaction;
import com.group1.energymanager.model.User;
import com.group1.energymanager.repo.PacketRepository;
import com.group1.energymanager.repo.TransactionRepository;
import com.group1.energymanager.repo.UserRepository;
import com.group1.energymanager.request.TransactionRequest;
import com.group1.energymanager.response.BaseResponse;
import com.group1.energymanager.response.ListTransactionResponse;
import com.group1.energymanager.response.TransactionResponse;
import com.group1.energymanager.solidity.Purchase;
import com.group1.energymanager.web3j.EtherPurchase;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.response.PollingTransactionReceiptProcessor;
import org.web3j.tx.response.TransactionReceiptProcessor;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final PacketRepository packetRepository;


    public static final String FUNC_TRANSACT = "transact";


    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, PacketRepository packetRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.packetRepository = packetRepository;
    }


    public ListTransactionResponse getAllTransactions(){
        ListTransactionResponse resp = new ListTransactionResponse();
        //recupero transazioni dal db
        List<Transaction> transactions = transactionRepository.findAll();
        //creo lista di transactionDTO
        List<TransactionDTO> listTransactionDTO = new ArrayList<>();
        TransactionDTO tmp;
        for(Transaction t : transactions) {
            tmp = new TransactionDTO();
            tmp.setTransactionID(t.getId());
            tmp.setSellerId(t.getSellerId().getId());
            tmp.setBuyerId(t.getBuyerId().getId());
            tmp.setPacketId(t.getPacketId().getId());
            tmp.setTime(t.getTime());
            listTransactionDTO.add(tmp);
        }
        //popolo la response
        BaseResponse result = new BaseResponse(HttpStatus.OK, "Found List of Transactions!");
        resp.setListTransactionDTO(listTransactionDTO);
        resp.setResult(result);
        return resp;
    }


    public TransactionResponse addTransaction(
            @NotNull TransactionRequest transactionRequest)
                throws UserNotFoundException, PacketNotFoundException, Exception {
        //costruisco l'oggetto wrapper della classe dello smart contract
        EtherPurchase purchase = new EtherPurchase();

        //chiedo i parametri alla richiesta ricevuta
        User seller = userRepository.findById(transactionRequest.getSellerId())
                .orElseThrow(() -> new UserNotFoundException("Seller " + transactionRequest.getSellerId() + " Not Found!"));
        User buyer = userRepository.findById(transactionRequest.getBuyerId())
                .orElseThrow(() -> new UserNotFoundException("Buyer " + transactionRequest.getBuyerId() + " Not Found!"));
        Packet packet = packetRepository.findById(transactionRequest.getPacketId())
                .orElseThrow(() -> new PacketNotFoundException("Packet " + transactionRequest.getPacketId() + " Not Found!"));

        Web3j web3j = EtherPurchase.getWeb3j();
        EtherPurchase.getLog().info("web3j "+ web3j.toString());

        Credentials credentials = EtherPurchase.getCredentials();
        EtherPurchase.getLog().info("credentials "+ credentials.getAddress());

        ContractGasProvider contractGasProvider = EtherPurchase.getContractGasProvider();
        EtherPurchase.getLog().info("gas "+ contractGasProvider.toString());

        String contractAddress = EtherPurchase.getContract().getContractAddress();
        EtherPurchase.getLog().info("contract "+ EtherPurchase.getContract().toString() + " " + contractAddress);

        Purchase contract = EtherPurchase.getContract();

        org.web3j.abi.datatypes.Function function = new Function(
                FUNC_TRANSACT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(seller.getId()),
                        new org.web3j.abi.datatypes.Utf8String(buyer.getId()),
                        new org.web3j.abi.datatypes.generated.Uint256(packet.getQuantity()),
                        new org.web3j.abi.datatypes.generated.Uint256(packet.getPrice())),
                Collections.<TypeReference<?>>emptyList());

        //Encode function values in transaction data format
        String txData = FunctionEncoder.encode(function);

        // RawTransactionManager use a wallet (credential) to create and sign transaction
        TransactionManager txManager = new RawTransactionManager(web3j, credentials);

        // Send transaction
        String txHash = txManager.sendTransaction(
                DefaultGasProvider.GAS_PRICE,
                DefaultGasProvider.GAS_LIMIT,
                contractAddress,
                txData,
                BigInteger.ZERO).getTransactionHash();

        // Wait for transaction to be mined
        TransactionReceiptProcessor receiptProcessor = new PollingTransactionReceiptProcessor(
                web3j,
                TransactionManager.DEFAULT_POLLING_FREQUENCY,
                TransactionManager.DEFAULT_POLLING_ATTEMPTS_PER_TX_HASH);
        TransactionReceipt txReceipt = receiptProcessor.waitForTransactionReceipt(txHash);

        EtherPurchase.getLog().info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
                + txReceipt.getTransactionHash());

        //creo nuova transazione nel db
        Transaction newTransaction = new Transaction();
        //setto i valori di transaction, senza id perché viene generato automaticamente
        newTransaction.setId(contractAddress);
        newTransaction.setSellerId(seller);
        newTransaction.setBuyerId(buyer);
        newTransaction.setPacketId(packet);
        newTransaction.setTime(new Timestamp(System.currentTimeMillis()));
        transactionRepository.save(newTransaction);

        //popolo la response
        BaseResponse result = new BaseResponse(HttpStatus.CREATED, "Transaction " + newTransaction.getId() + " successfully created!");
        TransactionResponse resp = new TransactionResponse();
        resp.setResult(result);
        resp.setTransaction(newTransaction.toDTO());
        resp.getTransaction().setTransactionID(newTransaction.getId()); //non so perchè ci sia bisogno di settarlo così
        return resp;
    }

    /*private TransactionManager txManager(Web3j web3j, String address) {
        return new ClientTransactionManager(web3j, address);
    }*/
}