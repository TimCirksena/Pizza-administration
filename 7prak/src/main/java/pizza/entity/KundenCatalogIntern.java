package pizza.entity;



import pizza.boundary.exception.NoActiveBestellungException;

import javax.ws.rs.NotFoundException;

public interface KundenCatalogIntern {
    Bestellung getAktiveBestellungById(long kundenId) throws NoActiveBestellungException;
    Bestellung createAktiveBestellung(long kundenId);
}
