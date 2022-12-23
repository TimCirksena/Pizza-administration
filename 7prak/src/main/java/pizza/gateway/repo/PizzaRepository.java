package pizza.gateway.repo;

import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
@ApplicationScoped
public class PizzaRepository implements PizzaCatalog {
    @Override
    public ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId) {
        return null;
    }

    @Override
    public List<PizzaDTO> pizzanAbfragen() {
        return null;
    }

    @Override
    public BestellungDTO bestellungAbfragen(long kundenId) {
        return null;
    }

    @Override
    public PizzaDTO pizzaAbfragen(Long pizzaId) {
        return null;
    }

    @Override
    public ReturnBestellpostenDTO bestellpostenAendern(long kundenId, long bestellpostenId, POSTBestellpostenDTO bestellpostenDTO) {
        return null;
    }

    @Override
    public BestellungDTO bestellungAbschicken(long kundenId) {
        return null;
    }
}
