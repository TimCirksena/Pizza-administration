package pizza.boundary.acl;

import pizza.entity.Pizza;

public class PizzaDTO {
    public long pizzaId;
    public float groesse;
    public String beschreibung;
    public String name;
    public double preis;

    public PizzaDTO(Pizza pizza){
        this.pizzaId = pizza.getPizzaID();
        this.groesse = pizza.getGroesse();
        this.beschreibung = pizza.getBeschreibung();
        this.name = pizza.getName();
        this.preis = pizza.getPreis();
    }
}
