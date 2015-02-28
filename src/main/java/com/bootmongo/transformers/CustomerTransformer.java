/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo.transformers;

import com.bootmongo.domain.Customer;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author b1050502
 */
public class CustomerTransformer {

    public synchronized String toXml(final Customer customer) throws JAXBException {
        final StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        if (customer == null) {
            Customer bbean = new Customer();
            marshaller.marshal(bbean, stringWriter);
        } else {
            marshaller.marshal(customer, stringWriter);
        }

        return stringWriter.toString();
    }

    public synchronized Customer fromXml(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        StringReader reader = new StringReader(xml);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Customer bean = (Customer) jaxbUnmarshaller.unmarshal(reader);
        return bean;
    }

}
