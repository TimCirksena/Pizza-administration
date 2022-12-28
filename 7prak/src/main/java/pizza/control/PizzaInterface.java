package pizza.control;

import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;

import java.util.List;

public interface PizzaInterface {
    ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId);
    List<PizzaDTO> pizzenAbfragen();
    BestellungDTO bestellungAbfragen(long kundenId);
    PizzaDTO pizzaAbfragen(Long pizzaId);
    ReturnBestellpostenDTO bestellpostenAendern(long kundenId, long bestellpostenId, POSTBestellpostenDTO bestellpostenDTO);
    BestellungDTO bestellungAbschicken(long kundenId);
}
