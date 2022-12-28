package pizza.boundary.rest;

import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.control.PizzaInterface;

import javax.annotation.security.RolesAllowed;
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
    PizzaInterface pizza;
    @GET
    public Response getAllPizzas(){
        return Response.ok(pizza.pizzanAbfragen()).build();
    }

    @GET
    @Path("/{pizzaID}")
    public Response getPizza(@PathParam("pizzaID") long pizzaID){
        return Response.ok(pizza.pizzaAbfragen(pizzaID)).build();
    }

    @POST
    @RolesAllowed("user")
    @Path("/{kundenID}")
    public Response postBestellungsposten( POSTBestellpostenDTO postBestellpostenDTO, @PathParam("kundenID") long kundenID){
        return Response.ok(pizza.addBestellposten(postBestellpostenDTO, kundenID)).build();
    }

    @PATCH
    @RolesAllowed("user")
    @Path("/{kundenID}/{bestellpostenID}")
    public Response patchBestellungsposten(@PathParam("kundenID") long kundenID, @PathParam("bestellpostenID") long bestellpostenID, POSTBestellpostenDTO postBestellpostenDTO){
        return Response.ok(pizza.bestellpostenAendern(kundenID, bestellpostenID, postBestellpostenDTO)).build();
    }
}
