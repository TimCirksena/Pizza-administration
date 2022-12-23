package pizza.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Cacheable
public class Bestellposten extends PanacheEntityBase {

    @Id
    @SequenceGenerator(
            name = "BestellpostenSequence",
            sequenceName = "Bestellposten_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BestellpostenSequence")
    private long postenID;
    @Column
    private int menge;

    @OneToOne(cascade = CascadeType.MERGE)

    private Pizza pizza;

    public Bestellposten(){}

    public Bestellposten(long postenID, int menge, Pizza pizza) {
        this.postenID = postenID;
        this.menge = menge;
        this.pizza = pizza;
    }

    public long getPostenID() {
        return postenID;
    }

    public void setPostenID(long postenID) {
        this.postenID = postenID;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
