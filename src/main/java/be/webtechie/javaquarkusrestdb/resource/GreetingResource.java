package be.webtechie.javaquarkusrestdb.resource;

import java.time.LocalDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @GET
    @Path("timestamp")
    @Produces(MediaType.TEXT_PLAIN)
    public LocalDateTime time() {
        return LocalDateTime.now();
    }
}