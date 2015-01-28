package com.chepseskaf.server;

import javax.ws.rs.*;

public class MyBeanParam {
    
    @PathParam("p")
    private String pathParam;
 
    @MatrixParam("m")
    @Encoded
    @DefaultValue("default")
    private String matrixParam;
 
    @HeaderParam("header")
    private String headerParam;
 
    private String queryParam;
 
    public MyBeanParam(@QueryParam("q") String queryParam) {
        this.queryParam = queryParam;
    }
 
    public String getPathParam() {
        return pathParam;
    }

    @Override
    public String toString() {
        return "MyBeanParam{" +
                "pathParam='" + pathParam + '\'' +
                ", matrixParam='" + matrixParam + '\'' +
                ", headerParam='" + headerParam + '\'' +
                ", queryParam='" + queryParam + '\'' +
                '}';
    }
}