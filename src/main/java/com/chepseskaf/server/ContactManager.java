package com.chepseskaf.server;

import com.chepseskaf.server.contact.Address;
import com.chepseskaf.server.contact.Contact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Arrays;
import java.util.List;

/**
 * @author chepseskaf
 */
@Path("contact")
public class ContactManager {
    @GET
    @Produces("application/json")
    public List<Contact> list() {
        return Arrays.asList(
                new Contact(1, "Harvey", Arrays.asList(new Address("High Street", "Paris"))),
                new Contact(2, "Mike", Arrays.asList(new Address("Down Street", "Toulouse")))

        );
    }
}
