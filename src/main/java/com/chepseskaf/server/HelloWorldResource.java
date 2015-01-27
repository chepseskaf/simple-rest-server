package com.chepseskaf.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
 
@Path(HelloWorldResource.PATH)
public class HelloWorldResource {
    public static final String PATH = "helloworld";
    public static final String CLICHED_MESSAGE = "Hello World!";

@GET
@Produces("text/plain")
    public String getHello() {
        return CLICHED_MESSAGE;
    }
}