package pizza.boundary.rest;

import pizza.boundary.acl.POSTKundeDTO;
import pizza.control.KundenController;
import pizza.control.KundenInterface;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/api/kunden")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KundenResource {
    @Inject
    KundenInterface controller;
    @GET
    @RolesAllowed("admin")
    @Path("/allKunden")
    public Response getAllKunden(){
        return Response.ok(controller.getAllKunden()).build();
    }

    @POST
    public Response addKunde(POSTKundeDTO postKundeDTO){
        return Response.ok(controller.addKunde(postKundeDTO.username, postKundeDTO.password, postKundeDTO.role)).build();
    }

    @GET
    @RolesAllowed("user")
    @Path("/me")
    @Produces(MediaType.TEXT_PLAIN)
    public String me(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }

    @GET
    @RolesAllowed({"user","admin"})
    @Path("/boid")
    @Produces(MediaType.TEXT_PLAIN)
    public String boid() {
        return "hi";
    }
}
