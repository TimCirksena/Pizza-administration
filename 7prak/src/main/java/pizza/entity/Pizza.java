package pizza.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import pizza.boundary.acl.PizzaDTO;

import javax.persistence.*;

@Entity
@Cacheable
public class Pizza extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "PizzaSequence",
            sequenceName = "Pizza_id_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PizzaSequence")
    @Basic(optional = false)
    private long pizzaID;
    @Column
    private float groesse;
    @Column
    private String beschreibung;
    @Column
    private String name;
    @Column
    private double preis;

    public Pizza() {
    }


    public Pizza(PizzaDTO pizza) {
        this.pizzaID = pizza.pizzaId;
        this.groesse = pizza.groesse;
        this.beschreibung = pizza.beschreibung;
        this.name = pizza.name;
        this.preis = pizza.preis;
    }

    public Pizza(float groesse, String beschreibung, String name, double preis) {
        this.groesse = groesse;
        this.beschreibung = beschreibung;
        this.name = name;
        this.preis = preis;
    }

    public long getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(long pizzaID) {
        this.pizzaID = pizzaID;
    }

    public float getGroesse() {
        return groesse;
    }

    public void setGroesse(float groesse) {
        this.groesse = groesse;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
