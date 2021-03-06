/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo;

import com.bootmongo.domain.Customer;
import com.bootmongo.domain.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Ian
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    CustomerRepository repository;
    
    private static final Logger log =LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
    }
    
    @Override
    public void run(String... args) throws Exception {
        log.info("run()");
        
        repository.deleteAll();
        
        repository.save(new Customer("Smith", "Walter"));
        repository.save(new Customer("Smith", "Tatiana"));
    }
    
    
    
}
