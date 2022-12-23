package pizza.control;

import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped
public class PizzaController {

    @Inject
    PizzaCatalog pizzaRepo;

    public ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId) {
        return pizzaRepo.addBestellposten(postBestellpostenDTO, kundenId);
    }

    public List<PizzaDTO> pizzanAbfragen() {
        return pizzaRepo.pizzanAbfragen();
    }

    public BestellungDTO bestellungAbfragen(long kundenId) {
        return pizzaRepo.bestellungAbfragen(kundenId);
    }


    public PizzaDTO pizzaAbfragen(Long pizzaId) {
        return pizzaRepo.pizzaAbfragen(pizzaId);
    }

    public ReturnBestellpostenDTO bestellpostenAendern(long kundenId, long bestellpostenId, POSTBestellpostenDTO bestellpostenDTO) {
        return pizzaRepo.bestellpostenAendern(kundenId,bestellpostenId,bestellpostenDTO);
    }


    public BestellungDTO bestellungAbschicken(long kundenId) {
        return pizzaRepo.bestellungAbschicken(kundenId);
    }
}
