package pizza.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Cacheable
public class Bestellung extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "BestellungSequence",
            sequenceName = "Bestellung_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BestellungSequence")
    private long bestellungID;
    @Column
    private boolean bestellungFertig;
    @Column
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Bestellposten> bestellposten;

    public Bestellung(){}

    public Bestellung(long bestellungID, boolean bestellungFertig, List<Bestellposten> bestellposten) {
        this.bestellungID = bestellungID;
        this.bestellungFertig = bestellungFertig;
        this.bestellposten = bestellposten;
    }
    public Bestellung(boolean bestellungFertig, List<Bestellposten> bestellposten){
        this.bestellungFertig = bestellungFertig;
        this.bestellposten = bestellposten;
    }

    public long getBestellungID() {
        return bestellungID;
    }

    public void setBestellungID(long bestellungID) {
        this.bestellungID = bestellungID;
    }

    public boolean isBestellungFertig() {
        return bestellungFertig;
    }

    public void setBestellungFertig(boolean bestellungFertig) {
        this.bestellungFertig = bestellungFertig;
    }

    public List<Bestellposten> getBestellposten() {
        return bestellposten;
    }

    public void setBestellposten(List<Bestellposten> bestellposten) {
        this.bestellposten = bestellposten;
    }
}
