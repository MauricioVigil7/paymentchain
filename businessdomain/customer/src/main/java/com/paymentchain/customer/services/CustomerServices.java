/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.paymentchain.customer.services;

import com.paymentchain.customer.entities.Customer;
import java.net.UnknownHostException;
import java.util.List;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author HP
 */

public interface CustomerServices {
    public abstract Customer getByCode(String code);
    public abstract String getProductName(long id)throws UnknownHostException ;
    public abstract ResponseEntity<?> delete(long id);
    public abstract ResponseEntity<?> save(Customer input);
    public abstract ResponseEntity<?> update(long id, Customer input);
    public abstract List<Customer> list();
    public abstract Customer findById(long id);
    public abstract <T> List<T> getTransacctions(String accountIban);
    
   
    
}
