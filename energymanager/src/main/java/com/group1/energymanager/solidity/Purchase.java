package com.group1.energymanager.solidity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Purchase extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061052c806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80636f2ca2fc1461003b5780639ace38c214610050575b600080fd5b61004e6100493660046103a8565b61007c565b005b61006361005e36600461041c565b61011c565b6040516100739493929190610482565b60405180910390f35b604080516080810182528581526020808201869052918101849052606081018390526000805460018101825590805281518051929360049092027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e56301926100e6928492019061026c565b5060208281015180516100ff926001850192019061026c565b506040820151816002015560608201518160030155505050505050565b6000818154811061012c57600080fd5b906000526020600020906004020160009150905080600001805461014f906104bb565b80601f016020809104026020016040519081016040528092919081815260200182805461017b906104bb565b80156101c85780601f1061019d576101008083540402835291602001916101c8565b820191906000526020600020905b8154815290600101906020018083116101ab57829003601f168201915b5050505050908060010180546101dd906104bb565b80601f0160208091040260200160405190810160405280929190818152602001828054610209906104bb565b80156102565780601f1061022b57610100808354040283529160200191610256565b820191906000526020600020905b81548152906001019060200180831161023957829003601f168201915b5050505050908060020154908060030154905084565b828054610278906104bb565b90600052602060002090601f01602090048101928261029a57600085556102e0565b82601f106102b357805160ff19168380011785556102e0565b828001600101855582156102e0579182015b828111156102e05782518255916020019190600101906102c5565b506102ec9291506102f0565b5090565b5b808211156102ec57600081556001016102f1565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261032c57600080fd5b813567ffffffffffffffff8082111561034757610347610305565b604051601f8301601f19908116603f0116810190828211818310171561036f5761036f610305565b8160405283815286602085880101111561038857600080fd5b836020870160208301376000602085830101528094505050505092915050565b600080600080608085870312156103be57600080fd5b843567ffffffffffffffff808211156103d657600080fd5b6103e28883890161031b565b955060208701359150808211156103f857600080fd5b506104058782880161031b565b949794965050505060408301359260600135919050565b60006020828403121561042e57600080fd5b5035919050565b6000815180845260005b8181101561045b5760208185018101518683018201520161043f565b8181111561046d576000602083870101525b50601f01601f19169290920160200192915050565b6080815260006104956080830187610435565b82810360208401526104a78187610435565b604084019590955250506060015292915050565b600181811c908216806104cf57607f821691505b602082108114156104f057634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122045e5ee6614b0ecdc93923632ecdfa03a96db99813e205a7f1950419d5f8c8f5164736f6c634300080b0033";

    public static final String FUNC_TRANSACT = "transact";

    public static final String FUNC_TRANSACTIONS = "transactions";

    @Deprecated
    protected Purchase(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Purchase(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Purchase(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Purchase(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> transact(String _seller, String _buyer, Integer _quantity, Integer _price) {
        final Function function = new Function(
                FUNC_TRANSACT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_seller), 
                new org.web3j.abi.datatypes.Utf8String(_buyer), 
                new org.web3j.abi.datatypes.generated.Uint256(_quantity), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>> transactions(BigInteger param0) {
        final Function function = new Function(FUNC_TRANSACTIONS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, BigInteger>>(function,
                new Callable<Tuple4<String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    @Deprecated
    public static Purchase load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Purchase(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Purchase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Purchase(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Purchase load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Purchase(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Purchase load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Purchase(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Purchase> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Purchase.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Purchase> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Purchase.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Purchase> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Purchase.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Purchase> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Purchase.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
