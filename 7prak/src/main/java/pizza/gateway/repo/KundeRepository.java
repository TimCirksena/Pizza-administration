package pizza.gateway.repo;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.runtime.StartupEvent;
import pizza.boundary.acl.BestellungDTO;
import pizza.boundary.acl.ReturnKundeDTO;
import pizza.boundary.exception.NoActiveBestellungException;
import pizza.entity.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class KundeRepository implements KundenCatalog, KundenCatalogIntern {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        // reset and load all test users
        Kunde.deleteAll();
        addKunde("admin", "admin", "admin");
        addKunde("user", "user", "kunde");
    }

    @Override
    public List<ReturnKundeDTO> getAllKunden() {
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
    public ReturnKundeDTO addKunde(String username, String password, String role) {
        Kunde kunde = new Kunde();
        kunde.setUsername(username);
        kunde.setPassword(BcryptUtil.bcryptHash(password));
        kunde.setRole(role);
        kunde.persist();
        return new ReturnKundeDTO(kunde);
    }
    /**
     * returns true if at least 1 kunde has been deleted
     * */
    @Override
    public Boolean deleteKunde(String username) {
        long amountDeleted = Kunde.delete("username", username);
        return amountDeleted > 0;
    }
    @Override
    public Bestellung getAktiveBestellungById(long kundenId) {
        Kunde k = Kunde.findById(kundenId);
            for (int i = 0; i<k.getBestellungList().size(); i++){
                if(!k.getBestellungList().get(i).isBestellungFertig()){
                    return k.getBestellungList().get(i);

                }
            }
        return createAktiveBestellung(kundenId);
    }
    @Override
    public Bestellung createAktiveBestellung(long kundenId) {
        List<Bestellposten> bestellposten = new ArrayList<>();
        Bestellung bestellung = new Bestellung(false,bestellposten);
        findKundeById(kundenId).getBestellungList().add(bestellung);
        bestellung.persist();
        return bestellung;
    }
    public Kunde findKundeById(long id){
        return Kunde.findById(id);
    }

    @Override
    public Long getKundenIdByUsername(String username) {
        Kunde k = Kunde.find("username", username).firstResult();
        return k.id;
    }

    @Override
    public List<BestellungDTO> getAllBestellung(){
        List<Bestellung> bestellungs = Bestellung.listAll();
        List<BestellungDTO> bestellungDTOS = new ArrayList<>();
        for (Bestellung b: bestellungs) {
            bestellungDTOS.add(new BestellungDTO(b));
        }
        return bestellungDTOS;
    }
}
