/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo.web;

import com.bootmongo.domain.Customer;
import com.bootmongo.domain.CustomerRepository;
import com.bootmongo.domain.Customers;
import com.bootmongo.transformers.CustomerTransformer;
import com.bootmongo.transformers.CustomersTransformer;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ian
 */
@RestController
//@RequestMapping("/api/customer")
public class CustomerController {
        
    private static final Logger log =LoggerFactory.getLogger(CustomerController.class);

    private CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/api/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) throws JAXBException {
        log.info("create: "+customer);
        repository.save(customer);
        return customer;
    }

    @RequestMapping(value="/api/customers", method =RequestMethod.GET)
    public Customers findAll() throws JAXBException {
        Customers customers =new Customers();
        List<Customer> list =repository.findAll();
        customers.add(list);
       return customers;
    }
}
