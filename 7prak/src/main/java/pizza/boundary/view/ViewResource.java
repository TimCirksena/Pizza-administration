package pizza.boundary.view;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.jboss.logging.annotations.Pos;
import pizza.boundary.acl.*;
import pizza.control.KundenController;
import pizza.control.KundenInterface;
import pizza.control.PizzaInterface;
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
import java.util.ArrayList;
import java.util.List;

@Path("/view")
@ApplicationScoped
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.TEXT_HTML)
public class ViewResource {
    @Inject
    Template pizzaList_view;
    @Inject
    PizzaInterface pizzaInterface;

    @Inject
    KundenInterface kundenInterface;
    @Inject
    Template login_view;

    @Inject
    Template register_view;

    @Inject
    Template mainMenu_view;

    @Inject
    Template pizzaBestellen_view;

    @GET
    @Path("/pizzaList")
    @RolesAllowed("kunde")
    @Transactional
    public TemplateInstance getPizzaList(){
        //List<String> stringList = new ArrayList<>();
        //stringList.add("hi");
        //stringList.add("moin");
        return pizzaList_view.data("pizzas",pizzaInterface.pizzenAbfragen());
    }

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
    @RolesAllowed("kunde")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getMainMenu() {
        return mainMenu_view.data("lol");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/bestellen")
    @RolesAllowed("kunde")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response postBestellenView(@Context SecurityContext securityContext, HtmlPizzaDTO htmlPizzaDTO) {
        POSTBestellpostenDTO postBestellpostenDTO = new POSTBestellpostenDTO(htmlPizzaDTO);
        System.out.println(postBestellpostenDTO.toString());
        return Response.ok(pizzaInterface.addBestellposten(postBestellpostenDTO,kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName()))).build();

    }
    @GET
    @Path("/bestellen")
    @RolesAllowed("kunde")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getBestellenView() {
            return pizzaBestellen_view.instance();

    }
}
