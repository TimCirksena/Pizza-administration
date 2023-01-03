package pizza.boundary.view;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.jboss.logging.annotations.Pos;
import pizza.boundary.acl.*;
import pizza.boundary.exception.NoActiveBestellungException;
import pizza.control.KundenController;
import pizza.control.KundenInterface;
import pizza.control.PizzaInterface;
import pizza.entity.Pizza;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.print.attribute.standard.Media;
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

    @Inject
    Template aktuelleBestellung_view;

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
    @Path("/listBestellung")
    @RolesAllowed("kunde")
    @Transactional
    public TemplateInstance getBestellungList(@Context SecurityContext securityContext) throws NoActiveBestellungException {
        return aktuelleBestellung_view.data("bestellung",pizzaInterface.bestellungAbfragen(kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName())));
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/listBestellung")
    @RolesAllowed("kunde")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response postBestellungList(@Context SecurityContext securityContext, boolean ja){
        try{
            System.out.println("JAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            return Response.ok(pizzaInterface.bestellungAbschicken(kundenInterface.getKundenIdByUsername(securityContext.getUserPrincipal().getName()))).build();
        }catch (NoActiveBestellungException e){//hier tims exception abfangen
            return Response.noContent().build();
        }
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

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response postRegister(@Context SecurityContext securityContext, HtmlKundeDTO htmlKundeDTO){
        //return Response.ok(kundenInterface.addKunde(htmlKundeDTO.uname, htmlKundeDTO.psw, "kunde")).build();
        kundenInterface.addKunde(htmlKundeDTO.uname, htmlKundeDTO.psw, "kunde");
        AdresseDTO adresseDTO = new AdresseDTO();
        adresseDTO.plz = htmlKundeDTO.pl;
        adresseDTO.ort = htmlKundeDTO.or;
        adresseDTO.strasseUndHausnummer = htmlKundeDTO.struH;
        return Response.ok(kundenInterface.addAdresse(kundenInterface.getKundenIdByUsername(htmlKundeDTO.uname), adresseDTO)).build();
    }

    @GET
    @Path("/menu")
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
