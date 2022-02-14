package com.group1.energymanager.web3j;
import com.group1.energymanager.solidity.Purchase;

import java.math.BigDecimal;
import java.math.BigInteger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

/**
    * <p>To run this demo, you will need to provide:
    *
    * <ol>
    *     <li>Ethereum client (or node) endpoint. The simplest thing to do is
    *     <a href="https://infura.io/register.html">request a free access token from Infura</a></li>
    *     <li>A wallet file. This can be generated using the web3j
    *     <a href="https://docs.web3j.io/command_line.html">command line tools</a></li>
    *     <li>Some Ether. This can be requested from the
    *     <a href="https://www.rinkeby.io/#faucet">Rinkeby Faucet</a></li>
    * </ol>
    *
*/

public class EtherPurchase {


    private static final Logger log = LoggerFactory.getLogger(EtherPurchase.class);
    private static Web3j web3j;
    private static Credentials credentials;
    private static Purchase contract;
    private static ContractGasProvider contractGasProvider;

    public EtherPurchase() throws Exception {
        contractGasProvider = new DefaultGasProvider();
        connect("https://rinkeby.infura.io/v3/792a2241b1114f9db7e9ad7fa56f1f2c");
        loadWallet("src/main/java/com/group1/energymanager/wallet/UTC--2022-02-07T09-01-34.146943000Z--49defc010bd1e71e1e3670cf737d400a3b14d4c2.json", "energyman");
        contract = Purchase.load("0xBd5c8B6BBca5CED35eBfC08fE1BF62D134c9Dc55", web3j , txManager(web3j, credentials.getAddress()), contractGasProvider);
    }

    private TransactionManager txManager(Web3j web3j, String address) {
        return new ClientTransactionManager(web3j, address);
    }

    public static Web3j connect(String client) throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        // Note: if using web3j Android, use Web3jFactory.build(...
        // FIXME: Enter your Infura token here; // FATTO!!!!!!!!!!!!!!!!!!!!!
        web3j = Web3j.build(new HttpService(
                //"https://rinkeby.infura.io/v3/792a2241b1114f9db7e9ad7fa56f1f2c"
                client));
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());

        return web3j;
    }

    public static Credentials loadWallet(String wallet, String password) throws Exception{
        // We then need to load our Ethereum wallet file
        // FIXME: Generate a new wallet file using the web3j command line tools
        //  https://docs.web3j.io/command_line.html // FATTO!!!!!!!!!!!!!!!!!!!!!
        credentials =
                WalletUtils.loadCredentials(
                        //"energyman",
                        password,
                        //"src/main/java/com/group1/energymanager/wallet/UTC--2022-02-07T09-01-34.146943000Z--" +
                        // "49defc010bd1e71e1e3670cf737d400a3b14d4c2.json"
                        wallet);
        log.info("Credentials loaded");

        return credentials;
    }

    public String deploy() throws Exception {
        // Now lets deploy a smart contract
        log.info("Deploying smart contract");
        contractGasProvider = new DefaultGasProvider();
        Purchase contract = Purchase.deploy(web3j, credentials, contractGasProvider).send();

        String contractAddress = contract.getContractAddress();
        log.info("Smart contract deployed to address " + contractAddress);
        log.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);

        return contractAddress;
    }

    /*public String value() throws Exception {
        BigInteger value = contract..send();
        log.info("Value stored in remote smart contract: " + value);
        return value.toString();
    }*/

    public String sendEther(Integer wei, String to) throws Exception {
        // FIXME: Request some Ether for the Rinkeby test network at
        //  https://www.rinkeby.io/#faucet // FATTO!!!!!!!!!!!!!!!!!!!!!

        log.info("Sending "+ wei +" Wei ("
                + Convert.fromWei(String.valueOf(wei), Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j,
                credentials,
                // FIXME: you can put any address here // FATTO!!!!!!!!!!!!!!!!!!!!! //0x49defc010bd1e71e1e3670cf737d400a3b14d4c2
                to,
                BigDecimal.ONE,
                Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        log.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
                + transferReceipt.getTransactionHash());

        return transferReceipt.getTransactionHash();
    }

    public static Web3j getWeb3j() {
        return web3j;
    }

    public static Credentials getCredentials() {
        return credentials;
    }

    public static Purchase getContract() {
        return contract;
    }

    public static ContractGasProvider getContractGasProvider() {
        return contractGasProvider;
    }

    public static Logger getLog() {
        return log;
    }

    /*private void run() throws Exception {

        // We start by creating a new web3j instance to connect to remote nodes on the network.
        // Note: if using web3j Android, use Web3jFactory.build(...
        // FIXME: Enter your Infura token here; // FATTO!!!!!!!!!!!!!!!!!!!!!
        Web3j web3j = Web3j.build(new HttpService(
                "https://rinkeby.infura.io/v3/792a2241b1114f9db7e9ad7fa56f1f2c"));
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());

        // We then need to load our Ethereum wallet file
        // FIXME: Generate a new wallet file using the web3j command line tools
        //  https://docs.web3j.io/command_line.html // FATTO!!!!!!!!!!!!!!!!!!!!!
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "energyman",
                        "src/main/java/com/group1/energymanager/wallet/UTC--2022-02-07T09-01-34.146943000Z--" +
                                "49defc010bd1e71e1e3670cf737d400a3b14d4c2.json");
        log.info("Credentials loaded");

        // FIXME: Request some Ether for the Rinkeby test network at
        //  https://www.rinkeby.io/#faucet // FATTO!!!!!!!!!!!!!!!!!!!!!

        log.info("Sending 1 Wei ("
                + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j,
                credentials,
                // FIXME: you can put any address here // FATTO!!!!!!!!!!!!!!!!!!!!!
                "0x49defc010bd1e71e1e3670cf737d400a3b14d4c2",
                BigDecimal.ONE,
                Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        log.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/"
                + transferReceipt.getTransactionHash());

        // Now lets deploy a smart contract
        log.info("Deploying smart contract");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        Purchase contract = Purchase.deploy(web3j, credentials, contractGasProvider).send();

        String contractAddress = contract.getContractAddress();
        log.info("Smart contract deployed to address " + contractAddress);
        log.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);

        log.info("Value stored in remote smart contract: " + contract.value().send());

        // Lets modify the value in our smart contract
        TransactionReceipt transactionReceipt = contract.;

        log.info("New value stored in remote smart contract: " + contract.greet().send());

        // Events enable us to log specific events happening during the execution of our smart
        // contract to the blockchain. Index events cannot be logged in their entirety.
        // For Strings and arrays, the hash of values is provided, not the original value.
        // For further information, refer to https://docs.web3j.io/filters.html#filters-and-events
        for (Greeter.ModifiedEventResponse event : contract.getModifiedEvents(transactionReceipt)) {
            log.info("Modify event fired, previous value: " + event.oldGreeting
                    + ", new value: " + event.newGreeting);
            log.info("Indexed event previous value: " + Numeric.toHexString(event.oldGreetingIdx)
                    + ", new value: " + Numeric.toHexString(event.newGreetingIdx));
        }*/
    }
