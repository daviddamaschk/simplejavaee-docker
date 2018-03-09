package de.mpc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Path("/sayhello")
public class HelloRs {


    @GET
    @Path("{name}")
    @Produces("text/plain")
    public String sayHelloTo(@PathParam("name") String name) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://spark:9999/hello/" + name);
        Response response = target.request().get();
        String result = response.readEntity(String.class);
        client.close();
        return result;
    }
}