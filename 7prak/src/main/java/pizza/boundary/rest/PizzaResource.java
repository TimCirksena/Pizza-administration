package pizza.boundary.rest;

import io.quarkus.security.jpa.Roles;
import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.control.KundenInterface;
import pizza.control.PizzaInterface;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationScoped
@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PizzaResource {
    @Inject
    PizzaInterface pizza;
    @Inject
    KundenInterface kundenInterface;
    @GET
    public Response pizzenAbfragen(){
        return Response.ok(pizza.pizzenAbfragen()).build();
    }

    @GET
    @Path("/{pizzaID}")
    public Response pizzaAbfragen(@PathParam("pizzaID") long pizzaID){
        return Response.ok(pizza.pizzaAbfragen(pizzaID)).build();
    }
    @GET
    @RolesAllowed("kunde")
    @Path("/bestellen")
    public Response bestellungAbfragen(@Context SecurityContext securityContext) {
        return Response.ok(kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName())).build();
    }
    @POST
    @RolesAllowed("kunde")
    @Path("/bestellen/abschicken")
    public Response bestellungAbschicken(@Context SecurityContext securityContext) {
        try{

        }catch (Exception e){//hier tims exception abfangen

        }
        return null;
    }

    @POST
    @RolesAllowed("kunde")
    public Response addBestellposten(@Context SecurityContext securityContext, POSTBestellpostenDTO postBestellpostenDTO){
        Long kundenID = kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName());
        return Response.ok(pizza.addBestellposten(postBestellpostenDTO, kundenID)).build();
    }

    @PATCH
    @RolesAllowed("user")
    @Path("/bestellen/{bestellpostenID}")
    public Response patchBestellungsposten(@Context SecurityContext securityContext, @PathParam("bestellpostenID") long bestellpostenID, POSTBestellpostenDTO postBestellpostenDTO){
        Long kundenID = kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName());
        return Response.ok(pizza.bestellpostenAendern(kundenID, bestellpostenID, postBestellpostenDTO)).build();
    }
}
