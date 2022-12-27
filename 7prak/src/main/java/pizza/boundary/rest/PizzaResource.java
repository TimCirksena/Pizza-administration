package pizza.boundary.rest;

import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
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

    @GET
    @Path("/{pizzaID}")
    public Response getPizza(@QueryParam("pizzaID") long pizzaID){
        return Response.ok(pizza.pizzaAbfragen(pizzaID)).build();
    }

}
