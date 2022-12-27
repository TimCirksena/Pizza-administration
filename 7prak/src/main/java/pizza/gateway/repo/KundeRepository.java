package pizza.gateway.repo;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.runtime.StartupEvent;
import pizza.boundary.acl.ReturnKundeDTO;
import pizza.entity.Kunde;
import pizza.entity.KundenCatalog;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

@ApplicationScoped
public class KundeRepository implements KundenCatalog {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
        Kunde.deleteAll();
        addKunde("admin", "admin", "admin");
        addKunde("user", "user", "user");
    }

    /**
     * Adds a new user to the database
     * @param username the username
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param role the comma-separated roles
     */

    @Override
    public ReturnKundeDTO addKunde(String username, String password, String role) {
        Kunde kunde = new Kunde();
        kunde.setUsername(username);
        kunde.setPassword(BcryptUtil.bcryptHash(password));
        kunde.setRole(role);
        kunde.persist();
        return new ReturnKundeDTO(kunde);
    }

    @Override
    public Boolean deleteKunde(String username, String password) {
        Kunde.find("username = ?1 and password = ?2", username, BcryptUtil.bcryptHash(password));
        //Kunde.delete()
        return null;
    }
}
