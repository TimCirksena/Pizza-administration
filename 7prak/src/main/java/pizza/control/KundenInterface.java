package pizza.control;

import pizza.boundary.acl.AdresseDTO;
import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Bestellung;

import java.util.Collection;
import java.util.List;

public interface KundenInterface {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username);
    List<ReturnKundeDTO> getAllKunden();
    Long getKundenIdByUsername(String username);
    ReturnKundeDTO addAdresse(Long kundenID, AdresseDTO adresse);
}
