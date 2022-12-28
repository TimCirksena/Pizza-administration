package pizza.control;

import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Bestellung;
import pizza.entity.KundenCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class KundenController implements KundenInterface{
    @Inject
    public KundenCatalog kundenCatalog;

    public ReturnKundeDTO addKunde(String username, String password, String role) {
        return kundenCatalog.addKunde(username,password,role);
    }

    public Boolean deleteKunde(String username, String password) {
        return kundenCatalog.deleteKunde(username,password);
    }

    public Collection<ReturnKundeDTO> getAllKunden() {
        return kundenCatalog.getAllKunden();
    }
}
