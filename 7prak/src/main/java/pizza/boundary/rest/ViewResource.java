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

@ApplicationScoped
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.TEXT_HTML)
public class ViewResource {
}
