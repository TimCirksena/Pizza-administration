package pizza.entity;

import pizza.boundary.acl.ReturnKundeDTO;

import java.util.Collection;

public interface KundenCatalog {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username, String password);

    Bestellung getAktiveBestellungById(long id);

    Collection<ReturnKundeDTO> getAllKunden();
}
