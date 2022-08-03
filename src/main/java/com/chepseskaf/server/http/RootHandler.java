package com.chepseskaf.server.http;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author chepseskaf
 */
public class RootHandler extends HttpHandler {
    public void service(Request request, Response response) throws Exception {
        response.setContentType("text/html");

        final StringBuilder sb = new StringBuilder();

        final Scanner scanner = new Scanner(Objects.requireNonNull(this.getClass().getResourceAsStream("/index.html")));
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine()).append('\n');
        }
        response.setContentLength(sb.length());
        response.getWriter().write(sb.toString());
    }
}
