/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.paymentchain.transactions.services;

import com.paymentchain.transactions.entities.Transaction;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.paymentchain.transactions.respository.TransactionRepository;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HP
 */
@Service
public class TransactionServicesImpl implements TransactionServices{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> list() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return transactionRepository.findAll();
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<Transaction> findById = transactionRepository.findById(id);   
        if(findById.get() != null){               
           transactionRepository.delete(findById.get());  
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> save(Transaction input) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Transaction save = transactionRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> update(long id, Transaction input) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Transaction find = transactionRepository.findById(id).get();  
        if(find != null){     
            find.setReference(input.getReference());
            find.setIbanAccount(input.getIbanAccount());
            //find.setDate(input.getDate());
            find.setAmount(input.getAmount());
            find.setFee(input.getFee());
            find.setDescription(input.getDescription());
            find.setStatus(input.getStatus());
            find.setChannel(input.getChannel());
        }
        Transaction save = transactionRepository.save(find);
        return ResponseEntity.ok(save);
    }

    @Override
    public Transaction findById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return transactionRepository.findById(id).get();
    }

    @Override
    public List<Transaction> findByIbanAccount(String ibanAccount) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return transactionRepository.findByIbanAccount(ibanAccount) ;
    
    }

   
   
 
        
    
    
    
}
