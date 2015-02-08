package com.chepseskaf.server.db;

import com.chepseskaf.server.contact.Address;
import com.chepseskaf.server.contact.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chepseskaf
 */
public class InitializeDatabase {
    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("hibernate.hbm2ddl.auto", "create");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa", map);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        Address nyc = new Address("Downing Street", "NYC");
        Contact harvey = new Contact("Harvey", Arrays.asList(nyc));
        entityManager.persist(nyc);
        entityManager.persist(harvey);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
