package com.chepseskaf.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import java.util.logging.Logger;

@Path("resource")
public class SummaryOfInjectionsResource {
    final static private Logger LOGGER = Logger.getLogger(SummaryOfInjectionsResource.class.getName());
    @QueryParam("query")
    String param; // injection into a class field


    @GET
    public String get(@QueryParam("query") String methodQueryParam) {
        // injection into a resource method parameter
        return "query param: " + param;
    }

    @Path("sub-resource-locator")
    public Class<SubResource> subResourceLocator(@QueryParam("query") String subResourceQueryParam) {
        // injection into a sub resource locator parameter
        return SubResource.class;
    }

    public SummaryOfInjectionsResource(@QueryParam("query") String constructorQueryParam) {
        // injection into a constructor parameter
    }


    @Context
    public void setRequest(Request request) {
        // injection into a setter method
        LOGGER.info("request == null ( " + (request != null) + ")");
        if (request != null) {
            LOGGER.info(request.getMethod());
        }
    }

}
