package pizza.entity;

import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.POSTBestellpostenDTO;
import pizza.boundary.acl.PizzaDTO;
import pizza.boundary.acl.ReturnBestellpostenDTO;
import pizza.boundary.exception.BestellpostenNonexistentException;
import pizza.boundary.exception.NoActiveBestellungException;

import java.util.List;

public interface PizzaCatalog {
    ReturnBestellpostenDTO addBestellposten(POSTBestellpostenDTO postBestellpostenDTO, long kundenId);
    List<PizzaDTO> pizzanAbfragen();
    BestellungDTO bestellungAbfragen(long kundenId) throws NoActiveBestellungException;
    PizzaDTO pizzaAbfragen(Long pizzaId);
    ReturnBestellpostenDTO bestellpostenAendern(long kundenId, long bestellpostenId, POSTBestellpostenDTO bestellpostenDTO) throws BestellpostenNonexistentException;
    BestellungDTO bestellungAbschicken(long kundenId) throws NoActiveBestellungException;
    List<BestellungDTO> getAllBestellungen();
}
