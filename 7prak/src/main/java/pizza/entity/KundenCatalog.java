package pizza.entity;

import pizza.boundary.acl.ReturnKundeDTO;

public interface KundenCatalog {
    ReturnKundeDTO addKunde(String username, String password, String role);
    Boolean deleteKunde(String username, String password);
}
