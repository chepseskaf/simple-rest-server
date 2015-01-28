package com.chepseskaf.server;

import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.glassfish.jersey.message.internal.OutboundMessageContext;
import org.glassfish.jersey.server.spi.Container;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path(MyResource.PATH)
public class MyResource {
    final public static String PATH = "/myresource";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "Got it!";
    }

    @Path("smooth")
    @GET
    public Response smooth(
            @DefaultValue("2") @QueryParam("step") int step,
            @DefaultValue("true") @QueryParam("min-m") boolean hasMin,
            @DefaultValue("true") @QueryParam("max-m") boolean hasMax,
            @DefaultValue("true") @QueryParam("last-m") boolean hasLast,
            @DefaultValue("blue") @QueryParam("min-color") ColorParam minColor,
            @DefaultValue("green") @QueryParam("max-color") ColorParam maxColor,
            @DefaultValue("red") @QueryParam("last-color") ColorParam lastColor) {

        OutboundMessageContext messageContext = new OutboundMessageContext();
        // FIXME: use css, because <font> is deprecated in html5
        final String context = "" +
                "<ul>\n" +
                "<li>step: " + step + "</li>\n" +
                "<li>min_m: " + hasMin + "</li>\n" +
                "<li>max-m: " + hasMax + "</li>\n" +
                "<li>last-m: " + hasLast + "</li>\n" +
                "<li>minColor: <font color=" + format(minColor) + ">" + minColor + "</font></li>\n" +
                "<li>maxColor: <font color=" + format(maxColor) + ">" + maxColor + "</font></li>\n" +
                "<li>lastColor: <font color=" + format(lastColor) + ">" + lastColor + "</font></li>\n" +
                "</ul>\n";
        messageContext.setEntity(context);
        return new OutboundJaxrsResponse(Response.Status.OK, messageContext);
    }

    private String format(ColorParam minColor) {
        return String.format("'#%02x%02x%02x'", minColor.getRed(), minColor.getGreen(), minColor.getBlue());
    }
}
