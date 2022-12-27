package pizza.gateway.repo;

import io.quarkus.panache.common.Sort;
import io.quarkus.runtime.StartupEvent;
import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.entity.Pizza;
import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@ApplicationScoped
public class PizzaRepository implements PizzaCatalog {
    @Override
    public ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId) {
        return null;
    }

    @Transactional
    public void loadPizzas(@Observes StartupEvent evt){
        Pizza.deleteAll();
        Pizza.add(100,"Mit Extra Käse.", "Mideum Margherita", 12.99);
        Pizza.add(80,"Mit Extra Käse.", "Smol Margherita", 9.99);
        Pizza.add(120,"Mit Extra Käse.", "Larsch Margherita", 15.99);
        Pizza.add(40,"Mit Extra Käse.", "Mini Margherita", 5.99);

    }

    @Override
    public List<PizzaDTO> pizzanAbfragen() {
        List<Pizza> pizzen = Pizza.listAll(Sort.by("pizzaID"));
        List<PizzaDTO> returnPizzen = new ArrayList<>();
        for (Pizza p: pizzen) {
            returnPizzen.add(new PizzaDTO(p));
        }
        return returnPizzen;
    }

    @Override
    public BestellungDTO bestellungAbfragen(long kundenId) {
        return null;
    }

    @Override
    public PizzaDTO pizzaAbfragen(Long pizzaId) {
        return new PizzaDTO(Pizza.findById(pizzaId));
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
