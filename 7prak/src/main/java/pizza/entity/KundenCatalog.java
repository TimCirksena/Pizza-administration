package pizza.entity;

import pizza.boundary.acl.ReturnKundeDTO;

import java.util.Collection;
import java.util.List;

public interface KundenCatalog {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username, String password);
    List<ReturnKundeDTO> getAllKunden();
}
