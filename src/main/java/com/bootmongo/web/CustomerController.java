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
@RequestMapping("/api/customer")
public class CustomerController {
        
    private static final Logger log =LoggerFactory.getLogger(CustomerController.class);

    private CustomerRepository repository;
    
    private CustomerTransformer customerTransformer;
    
    private CustomersTransformer customersTransformer;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
        this.customerTransformer =new CustomerTransformer();
        this.customersTransformer =new CustomersTransformer();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody String xml) throws JAXBException {
        log.info("create: "+xml);
        Customer customer =customerTransformer.fromXml(xml);
        repository.save(customer);
        return customerTransformer.toXml(customer);
    }
    
//    public String delete(String id) {
//        
//    }
//    
//    public String update(String xml) {
//        
//    }
    
//    public String find(String id) {
//        
//    }
    
    @RequestMapping(method =RequestMethod.GET)
    public String findAll() throws JAXBException {
        Customers customers =new Customers();
        List<Customer> list =repository.findAll();
        customers.setCustomers(list);
        return customersTransformer.toXml(customers);
    }
    
    
}
