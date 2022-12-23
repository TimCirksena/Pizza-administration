package pizza.gateway.repo;

import io.quarkus.runtime.StartupEvent;
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
        Kunde.add("admin", "admin", "admin");
        Kunde.add("user", "user", "user");
    }
}
