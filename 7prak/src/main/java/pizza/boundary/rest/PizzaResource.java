package pizza.boundary.rest;

import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.exception.NoActiveBestellungException;
import pizza.control.KundenInterface;
import pizza.control.PizzaInterface;
import pizza.gateway.repo.PizzaRepository;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

    @Inject
    PizzaRepository pizzaRepo;
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
    @Path("/bestellung")
    public Response bestellungAbfragen(@Context SecurityContext securityContext) {
        try {
            return Response.ok(pizza.bestellungAbschicken(kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName()))).build();
        } catch (NoActiveBestellungException e){
            return Response.noContent().build();
        }

    }
    @POST
    @Transactional
    @RolesAllowed("kunde")
    @Path("/bestellung/abschicken")
    public Response bestellungAbschicken(@Context SecurityContext securityContext) {
        try{
            return Response.ok(pizza.bestellungAbfragen(kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName()))).build();
        }catch (NoActiveBestellungException e){//hier tims exception abfangen
            return Response.noContent().build();
        }
    }

    @POST
    @Transactional
    @RolesAllowed("kunde")
    @Path("/bestellung")
    public Response addBestellposten(@Context SecurityContext securityContext, POSTBestellpostenDTO postBestellpostenDTO){
        Long kundenID = kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName());
        return Response.ok(pizza.addBestellposten(postBestellpostenDTO, kundenID)).build();
    }

    @PATCH
    @Transactional
    @RolesAllowed("kunde")
    @Path("/bestellung/{bestellpostenID}")
    public Response patchBestellungsposten(@Context SecurityContext securityContext, @PathParam("bestellpostenID") long bestellpostenID, POSTBestellpostenDTO postBestellpostenDTO){
        Long kundenID = kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName());
        return Response.ok(pizza.bestellpostenAendern(kundenID, bestellpostenID, postBestellpostenDTO)).build();
    }

    @GET
    @Path("/bestellungen")
    public Response getAllBestellungen(){
        return Response.ok(pizza.getAllBestellungen()).build();
    }

    @GET
    @Path("/debug")
    public Response get(){
        return Response.ok(pizzaRepo.get()).build();
    }
}
