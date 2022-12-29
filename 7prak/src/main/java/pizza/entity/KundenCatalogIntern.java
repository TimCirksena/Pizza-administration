package pizza.entity;



import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.exception.NoActiveBestellungException;

import javax.ws.rs.NotFoundException;
import java.util.List;

public interface KundenCatalogIntern {
    Bestellung getAktiveBestellungById(long kundenId) throws NoActiveBestellungException;
    Bestellung createAktiveBestellung(long kundenId);
    List<BestellungDTO> getAllBestellung();
}
