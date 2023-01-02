package pizza.control;

import pizza.boundary.acl.AdresseDTO;
import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Bestellung;
import pizza.entity.KundenCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class KundenController implements KundenInterface{
    @Inject
    public KundenCatalog kundenCatalog;

    public ReturnKundeDTO addKunde(String username, String password, String role) {
        return kundenCatalog.addKunde(username,password,role);
    }

    public Boolean deleteKunde(String username) {
        return kundenCatalog.deleteKunde(username);
    }

    public List<ReturnKundeDTO> getAllKunden() {
        return kundenCatalog.getAllKunden();
    }

    @Override
    public Long getKundenIdByUsername(String username) {
        return kundenCatalog.getKundenIdByUsername(username);
    }

    @Override
    public ReturnKundeDTO addAdresse(Long kundenID, AdresseDTO adresse) {
        return kundenCatalog.addAdresse(kundenID, adresse);
    }


}
