/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Ian
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
    
    @Id
    private String id;
    
     @XmlAttribute
    private String lastName;
    
      @XmlAttribute
    private String firstName;

    public Customer() {}

    public Customer(String lastName, String firstName) {
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + '}';
    }
    
}
