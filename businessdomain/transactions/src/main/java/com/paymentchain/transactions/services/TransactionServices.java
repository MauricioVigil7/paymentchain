/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.paymentchain.transactions.services;

import com.paymentchain.transactions.entities.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author HP
 */

public interface TransactionServices {
    public abstract List<Transaction> list();
    public abstract ResponseEntity<?> delete(long id);
    public abstract ResponseEntity<?> save(Transaction input);
    public abstract ResponseEntity<?> update(long id, Transaction input);
    public abstract Transaction findById(long id);
    public abstract List<Transaction> findByIbanAccount(String ibanAccount);
    
}
