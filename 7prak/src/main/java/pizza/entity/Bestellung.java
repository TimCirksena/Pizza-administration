package pizza.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Cacheable
public class Bestellung {
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
    @OneToMany
    private Collection<Bestellposten> bestellposten;

    public Bestellung(){}

    public Bestellung(long bestellungID, boolean bestellungFertig, Collection<Bestellposten> bestellposten) {
        this.bestellungID = bestellungID;
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

    public Collection<Bestellposten> getBestellposten() {
        return bestellposten;
    }

    public void setBestellposten(Collection<Bestellposten> bestellposten) {
        this.bestellposten = bestellposten;
    }
}
