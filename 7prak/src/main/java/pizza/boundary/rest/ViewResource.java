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
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
@Path("/view")
@ApplicationScoped
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.TEXT_HTML)
public class ViewResource {
    @Inject
    Template login_view;

    @Inject
    Template register_view;

    @Inject
    Template mainMenu_view;

    @Inject
    Template pizzaBestellen_view;

    @GET
    @Path("/login")
    public TemplateInstance getLogin(){
        return login_view.instance();
    }

    @GET
    @Path("/register")
    public TemplateInstance getRegister(){
        return register_view.instance();
    }

    @GET
    @Path("/menu")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getMainMenu() {
        return mainMenu_view.data("lol");
    }

    @GET
    @Path("/bestellen")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getBestellenView() {
        return pizzaBestellen_view.data("lol");
    }
}
