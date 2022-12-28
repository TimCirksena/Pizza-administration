package pizza.control;

import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Bestellung;

import java.util.Collection;

public interface KundenInterface {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username, String password);
    Collection<ReturnKundeDTO> getAllKunden();
}
