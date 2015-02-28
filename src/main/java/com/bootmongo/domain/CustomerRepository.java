/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo.domain;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * -derived queries inherited from Spring Data project
 * -write the methods and the queries are built for you
 * -CRUD methods supported
 * @author Ian
 */
public interface CustomerRepository extends MongoRepository<Customer, String>{
    
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
