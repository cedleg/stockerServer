package fr.cedleg.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/messages")
public class MessageRestService {
	
    @GET()
    @Path("hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello!";
    }
    
    @GET()
    @Path("bye")
    @Produces("text/plain")
    public String goodBye() {
        return "Goobye!";
    }
}
