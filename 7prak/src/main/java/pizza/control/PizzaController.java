package pizza.control;

import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.boundary.exception.BestellpostenNonexistentException;
import pizza.boundary.exception.NoActiveBestellungException;
import pizza.entity.PizzaCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
@ApplicationScoped
public class PizzaController implements PizzaInterface{

    @Inject
    PizzaCatalog pizzaRepo;

    public ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId) {
        return pizzaRepo.addBestellposten(postBestellpostenDTO, kundenId);
    }

    public List<PizzaDTO> pizzenAbfragen() {
        return pizzaRepo.pizzanAbfragen();
    }

    public BestellungDTO bestellungAbfragen(long kundenId) throws NoActiveBestellungException {
        return pizzaRepo.bestellungAbfragen(kundenId);
    }


    public PizzaDTO pizzaAbfragen(Long pizzaId) {
        return pizzaRepo.pizzaAbfragen(pizzaId);
    }

    public ReturnBestellpostenDTO bestellpostenAendern(long kundenId, long bestellpostenId, POSTBestellpostenDTO bestellpostenDTO) throws BestellpostenNonexistentException {
        return pizzaRepo.bestellpostenAendern(kundenId,bestellpostenId,bestellpostenDTO);
    }


    public BestellungDTO bestellungAbschicken(long kundenId) throws NoActiveBestellungException {
        return pizzaRepo.bestellungAbschicken(kundenId);
    }

    public List<BestellungDTO> getAllBestellungen(){
        return pizzaRepo.getAllBestellungen();
    }
}
