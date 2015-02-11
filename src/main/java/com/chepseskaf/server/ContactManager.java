package com.chepseskaf.server;

import com.chepseskaf.server.contact.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author chepseskaf
 */
@Path("contact")
public class ContactManager {
    private static final Logger LOGGER = Logger.getLogger(ContactManager.class.getName());
    
    @GET
    @Produces("application/json")
    public List<Contact> list() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager manager = factory.createEntityManager();
        try{
            manager.getTransaction().begin();
            return manager.createQuery("from Contact", Contact.class).getResultList();
        }finally {
            manager.getTransaction().commit();
            manager.close();
        }
    }
}
