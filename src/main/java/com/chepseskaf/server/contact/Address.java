package com.chepseskaf.server.contact;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
    public String street;
    public String town;
 
    public Address(){}
 
    public Address(String street, String town) {
        this.street = street;
        this.town = town;
    }
}