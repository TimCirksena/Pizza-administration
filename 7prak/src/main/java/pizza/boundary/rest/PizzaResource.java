package pizza.boundary.rest;

import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PizzaResource {
    @Inject
    PizzaCatalog pizza;
    @GET
    public Response getAllPizzas(){
        return Response.ok(pizza.pizzanAbfragen()).build();
    }

}
