package pizza.boundary.acl;

import pizza.entity.Kunde;

public class ReturnKundeDTO {
    public String username;
    public String role;

    public ReturnKundeDTO(){}
    public ReturnKundeDTO(Kunde kunde){
        username = kunde.getUsername();
        role = kunde.getRole();
    }
}
