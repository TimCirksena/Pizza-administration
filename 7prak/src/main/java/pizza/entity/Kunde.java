package pizza.entity;


import javax.persistence.*;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.smallrye.mutiny.Uni;
import org.hibernate.annotations.NamedQueries;

import java.util.Collection;
import java.util.List;

@Table(name = "kunde_table")
@Entity
//@NamedQuery(name = "Kunde.findAll", query = "select k from Kunde k order by k.id")
@UserDefinition
public class Kunde extends PanacheEntity {

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    @OneToMany
    private List<Bestellung> bestellungList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Bestellung> getBestellungList() {
        return bestellungList;
    }

    public void setBestellungCollection(List<Bestellung> bestellungList) {
        this.bestellungList = bestellungList;
    }



}
