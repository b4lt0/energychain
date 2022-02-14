
package com.group1.energymanager.service;

import com.group1.energymanager.DTOs.TransactionDTO;
import com.group1.energymanager.exceptions.PacketNotFoundException;
import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.model.Transaction;
import com.group1.energymanager.repo.PacketRepository;
import com.group1.energymanager.repo.TransactionRepository;
import com.group1.energymanager.repo.UserRepository;
import com.group1.energymanager.request.TransactionRequest;
import com.group1.energymanager.response.BaseResponse;
import com.group1.energymanager.response.ListTransactionResponse;
import com.group1.energymanager.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final PacketRepository packetRepository;




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

    public TransactionResponse addTransaction(TransactionRequest transactionRequest) throws UserNotFoundException, PacketNotFoundException {
        //creo nuova transazione nel db
        Transaction newTransaction = new Transaction();
        //setto i valori di transaction, senza id perchè viene generato automaticamente
        newTransaction.setSellerId(userRepository.findById(transactionRequest.getSellerId())
                .orElseThrow(() -> new UserNotFoundException("Seller " + transactionRequest.getBuyerId() + " Not Found!")));
        newTransaction.setBuyerId(userRepository.findById(transactionRequest.getBuyerId())
                .orElseThrow(() -> new UserNotFoundException("Buyer " + transactionRequest.getBuyerId() + " Not Found!")));
        newTransaction.setPacketId(packetRepository.findById(transactionRequest.getPacketId())
                .orElseThrow(() -> new PacketNotFoundException("Packet " + transactionRequest.getPacketId() + " Not Found!")));
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
}