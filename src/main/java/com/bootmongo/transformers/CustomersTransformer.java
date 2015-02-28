/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootmongo.transformers;

import com.bootmongo.domain.Customers;
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
public class CustomersTransformer {

    public synchronized String toXml(final Customers customers) throws JAXBException {
        final StringWriter stringWriter = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Customers.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        if (customers == null) {
            Customers bbean = new Customers();
            marshaller.marshal(bbean, stringWriter);
        } else {
            marshaller.marshal(customers, stringWriter);
        }

        return stringWriter.toString();
    }

    public synchronized Customers fromXml(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Customers.class);
        StringReader reader = new StringReader(xml);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Customers bean = (Customers) jaxbUnmarshaller.unmarshal(reader);
        return bean;
    }

}
