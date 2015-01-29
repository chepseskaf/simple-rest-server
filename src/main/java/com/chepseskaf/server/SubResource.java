package com.chepseskaf.server;

import javax.ws.rs.GET;

/**
* @author chepseskaf
*/
public class SubResource {
    @GET
    public String get() {
        return "sub resource";
    }
}
