package app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("")
public class ServiceIndex {

    @Context
    private UriInfo context;
    @Context
    protected HttpServletRequest request;
    @Context
    protected HttpServletResponse response;

    @GET
    public void redirect() throws Exception {

        String userAgent = request.getHeader("user-agent");

        if (userAgent != null) {
            userAgent = userAgent.toUpperCase();
        }

        System.out.println(userAgent);

        if (userAgent.contains("IPHONE") || userAgent.contains("IPAD")) {
            response.sendRedirect("https://apps.apple.com/br/app/uber/id368677368");
        } else if (userAgent.contains("ANDROID")) {
            response.sendRedirect("http://deeplink.fourti.me/deeplinkteste.apk");
        } else {
            response.sendRedirect("http://www.piebooking.com/");
        }
    }

}
