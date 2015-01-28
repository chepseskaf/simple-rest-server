package com.chepseskaf.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class ColorParam extends Color {
    private static final Logger LOGGER = Logger.getLogger(ColorParam.class.getName());
 
    public ColorParam(String s) {
        super(getRGB(s));
    }

    private static int getRGB(String s) {
        LOGGER.info("input = " + s);
        if (s.charAt(0) == '#') {
            try {
                Color c = Color.decode("0x" + s.substring(1));
                return c.getRGB();
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        } else {
            try {
                Field f = Color.class.getField(s);
                return ((Color)f.get(null)).getRGB();
            } catch (Exception e) {
                LOGGER.warning(e.getMessage());
                throw new WebApplicationException(Response.Status.BAD_REQUEST);
            }
        }
    }
}