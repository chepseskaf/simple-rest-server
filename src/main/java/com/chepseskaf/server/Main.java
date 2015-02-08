package com.chepseskaf.server;

import com.chepseskaf.server.http.RootHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.core.UriBuilder;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

/**
 * Main class.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.chepseskaf.server package
        final ResourceConfig rc = new ResourceConfig().packages("com.chepseskaf.server");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        //final URI uri = URI.create(BASE_URI);
        final URI uri = UriBuilder.fromUri("http://localhost").port(8080).build();
        return GrizzlyHttpServerFactory.createHttpServer(uri, rc);
    }

    /**
     * Main method.
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();

        final HttpServer server = startServer();
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        final EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        final Query q = manager.createQuery("SELECT COUNT(*) from Contact");
        final Object contact_count = q.getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        
        server.getServerConfiguration().addHttpHandler(new RootHandler(), "/index.html");
        LOGGER.info(String.format("Jersey app started with WADL available at "
                + "%s/application.wadl\nHit enter to stop it...\n", BASE_URI));
        LOGGER.info(String.format("%s", BASE_URI));
        
        

        LOGGER.info("Contacts: " + contact_count);
        LOGGER.info("\n  _________                           .__ \n" +
                " /   _____/ ____   ____   ______ ____ |__|\n" +
                " \\_____  \\_/ __ \\ /    \\ /  ___// __ \\|  |\n" +
                " /        \\  ___/|   |  \\\\___ \\\\  ___/|  |\n" +
                "/_______  /\\___  >___|  /____  >\\___  >__|\n" +
                "        \\/     \\/     \\/     \\/     \\/    ");

        Desktop.getDesktop().browse(URI.create(String.format("http://%s/index.html", BASE_URI)));
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                LOGGER.info("Closing...");
                
                factory.close();
                server.shutdownNow();        
            }
        }));
        
    }
}

