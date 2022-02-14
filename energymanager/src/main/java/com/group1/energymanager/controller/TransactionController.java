package com.group1.energymanager.controller;

import com.group1.energymanager.exceptions.PacketNotFoundException;
import com.group1.energymanager.exceptions.UserNotFoundException;
import com.group1.energymanager.request.TransactionRequest;
import com.group1.energymanager.response.ListTransactionResponse;
import com.group1.energymanager.response.TransactionResponse;
import com.group1.energymanager.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("/all")
    private ResponseEntity<ListTransactionResponse> findTransactions() {
        return new ResponseEntity<ListTransactionResponse>
                (transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @PostMapping("/add")
    private ResponseEntity<TransactionResponse> addTransaction(
            @RequestBody TransactionRequest transactionRequest)
                throws UserNotFoundException, PacketNotFoundException, Exception {
        return new ResponseEntity<TransactionResponse>
                (transactionService.addTransaction(transactionRequest), HttpStatus.CREATED);
    }
}
