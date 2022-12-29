package pizza.boundary.rest;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import pizza.boundary.acl.POSTKundeDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.StringDTO;
import pizza.control.KundenController;
import pizza.control.KundenInterface;
import pizza.entity.Pizza;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/kunden")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class KundenResource {
    @Inject
    KundenInterface controller;
    @Inject
    Template test;

    @GET
    @Path("/qute")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.name = "magerita mit sahne";
        pizzaDTO.preis = 2.22;
        pizzaDTO.beschreibung = "extra sauce";
        pizzaDTO.groesse = 88.8f;
        return test.data(pizzaDTO);
    }

    @GET
    @Transactional
    @RolesAllowed({"admin"})
    @Path("/allKunden")
    public Response getAllKunden(){
        return Response.ok(controller.getAllKunden()).build();
    }

    /**
     * jeder Nutzer darf ein Kundenkonto erstellen.
     * Andere Rollen sind nicht verfügbar
     * */
    @POST
    @Transactional
    public Response addKunde(POSTKundeDTO postKundeDTO){
        return Response.ok(controller.addKunde(postKundeDTO.username, postKundeDTO.password, "kunde")).build();
    }

    @DELETE
    @RolesAllowed("kunde")
    @Transactional
    public Response deleteKunde(@Context SecurityContext securityContext){
        if(controller.deleteKunde(securityContext.getUserPrincipal().getName())){
            return Response.ok(new StringDTO("Kunde erfolgreich gelöscht")).build();
        } else {
            return Response.status(404, "Kunde nicht vorhanden").build();
        }
    }
}
