package com.chepseskaf.server.contact;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

@Entity
@XmlRootElement
public class Contact {

    @Id
    @GeneratedValue
    public int id;
    public String name;
    @OneToMany(fetch = FetchType.EAGER)
    public List<Address> addresses;
 
    public Contact() {}
 
    public Contact(String name, List<Address> addresses) {
        this.name = name;
        this.addresses =
            (addresses != null) ? new LinkedList<>(addresses) : null;
    }

    public int getId() {
        return id;
    }
}