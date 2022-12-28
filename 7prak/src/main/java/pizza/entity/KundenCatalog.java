package pizza.entity;

import pizza.boundary.acl.ReturnKundeDTO;

import java.util.Collection;
import java.util.List;

public interface KundenCatalog {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username, String password);
    List<ReturnKundeDTO> getAllKunden();
    /**
     * diese methode darf nur mit dem namen des angemeldeten users aufgerufen werden, sonst entsteht eine sicherheitslücke
     * */
    Long getKundenIdByUsername(String username);
}
