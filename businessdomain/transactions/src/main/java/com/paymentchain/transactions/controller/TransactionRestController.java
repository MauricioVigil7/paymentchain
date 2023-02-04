/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paymentchain.transactions.controller;

import com.paymentchain.transactions.entities.Transaction;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.paymentchain.transactions.services.TransactionServices;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sotobotero
 */
@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
    
    @Autowired
    TransactionServices transactionServices;
    
    @GetMapping()
    public List<Transaction> list() {
        return transactionServices.list();
    }
    
    @GetMapping("/{id}")
    public Transaction get(@PathVariable long id) {
        return transactionServices.findById(id);
    }
    
    @GetMapping("/transactions")
    public List<Transaction> get(@RequestParam String ibanAccount) {
      return transactionServices.findByIbanAccount(ibanAccount);      
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable long id, @RequestBody Transaction input) {
        return transactionServices.update(id, input);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Transaction input) {
        return transactionServices.save(input);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {  
        return transactionServices.delete(id);
    }
    
}
