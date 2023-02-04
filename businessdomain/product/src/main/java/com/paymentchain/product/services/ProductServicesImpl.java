/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.paymentchain.product.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.paymentchain.product.entities.Product;
import com.paymentchain.product.respository.ProductRepository;
import io.netty.channel.ChannelOption;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 *
 * @author HP
 */
@Service
public class ProductServicesImpl implements ProductServices{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> list() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Optional<Product> findById = productRepository.findById(id);   
        if(findById.get() != null){               
           productRepository.delete(findById.get());  
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> save(Product input) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product save = productRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity<?> update(long id, Product input) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Product find = productRepository.findById(id).get();   
        if(find != null){     
            find.setCode(input.getCode());
            find.setName(input.getName());
        }
        Product save = productRepository.save(find);
        return ResponseEntity.ok(save);
    }

    @Override
    public Product findById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return productRepository.findById(id).get();
    }
   
    
    
    
}
