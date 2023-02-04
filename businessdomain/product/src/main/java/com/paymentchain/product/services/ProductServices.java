/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.paymentchain.product.services;

import com.paymentchain.product.entities.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author HP
 */

public interface ProductServices {
    public abstract List<Product> list();
    public abstract ResponseEntity<?> delete(long id);
    public abstract ResponseEntity<?> save(Product input);
    public abstract ResponseEntity<?> update(long id, Product input);
    public abstract Product findById(long id);

}
