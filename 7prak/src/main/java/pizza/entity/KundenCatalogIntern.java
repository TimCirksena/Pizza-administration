package pizza.entity;

import javax.ws.rs.NotFoundException;

public interface KundenCatalogIntern {
    Bestellung getAktiveBestellungById(long kundenId) throws NotFoundException;
    Bestellung createAktiveBestellung(long kundenId);
}
