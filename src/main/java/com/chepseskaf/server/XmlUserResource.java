package com.chepseskaf.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(XmlUserResource.PATH)
public class XmlUserResource {
    final static public String PATH = "/users/{username}";

    @GET
    @Produces("text/xml")
    public String getUser(@PathParam("username") String userName) {
        
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<user>" + userName + "</user>";
    }
}