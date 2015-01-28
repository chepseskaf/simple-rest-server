package com.chepseskaf.server;

import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.logging.Logger;

/**
 * @author chepseskaf
 */
@Path(PostRessourceToBean.PATH)
public class PostRessourceToBean {
    public final static String PATH = "/bean";
    private final static Logger LOGGER = Logger.getLogger(PostRessourceToBean.class.getName());
    
    @POST
    @Path("{p}")
    public void post(@BeanParam MyBeanParam beanParam, String entity) {
        LOGGER.info(beanParam.toString());
    }
}
