package pizza.gateway.repo;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.runtime.StartupEvent;
import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Bestellung;
import pizza.entity.Kunde;
import pizza.entity.KundenCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class KundeRepository implements KundenCatalog {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
        Kunde.deleteAll();
        addKunde("admin", "admin", "admin");
        addKunde("user", "user", "user");
    }

    @Override
    @Transactional
    public Collection<ReturnKundeDTO> getAllKunden() {
        Collection<Kunde> kunden = Kunde.findAll().list();
        List<ReturnKundeDTO> returnKundeDTOList = new ArrayList<>();
        for(Kunde k : kunden){
            returnKundeDTOList.add(new ReturnKundeDTO(k));
        }
        return returnKundeDTOList;
    }

    /**
     * Adds a new user to the database
     * @param username the username
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role the comma-separated roles
     */
    @Override
    @Transactional
    public ReturnKundeDTO addKunde(String username, String password, String role) {
        Kunde kunde = new Kunde();
        kunde.setUsername(username);
        kunde.setPassword(BcryptUtil.bcryptHash(password));
        kunde.setRole(role);
        kunde.persist();
        return new ReturnKundeDTO(kunde);
    }

    @Override
    @Transactional
    public Boolean deleteKunde(String username, String password) {
        Kunde.delete("username = ?1 and password = ?2", username, BcryptUtil.bcryptHash(password));
        return true;
    }

    @Override
    @Transactional
    public Bestellung getAktiveBestellungById(long id) {
        Kunde k = Kunde.findById(id);
        return null;
    }


}
