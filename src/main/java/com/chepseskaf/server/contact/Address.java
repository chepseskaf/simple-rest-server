package com.chepseskaf.server.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Address {
    @Id
    @GeneratedValue
    public Long id;
    public String street;
    public String town;
 
    public Address(){}
 
    public Address(String street, String town) {
        this.street = street;
        this.town = town;
    }
}