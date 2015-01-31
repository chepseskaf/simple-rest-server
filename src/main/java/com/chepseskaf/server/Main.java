package com.chepseskaf.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.ws.rs.core.UriBuilder;
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
        
        LOGGER.info(String.format("Jersey app started with WADL available at "
                + "%s/application.wadl\nHit enter to stop it...\n", BASE_URI));
        LOGGER.info(String.format("%s", BASE_URI));

        LOGGER.info("\n  _________                           .__ \n" +
                " /   _____/ ____   ____   ______ ____ |__|\n" +
                " \\_____  \\_/ __ \\ /    \\ /  ___// __ \\|  |\n" +
                " /        \\  ___/|   |  \\\\___ \\\\  ___/|  |\n" +
                "/_______  /\\___  >___|  /____  >\\___  >__|\n" +
                "        \\/     \\/     \\/     \\/     \\/    ");
        
        if(System.in.read() == -1) {
            System.out.println("nothing available");
        }
        server.shutdownNow();
    }
}

