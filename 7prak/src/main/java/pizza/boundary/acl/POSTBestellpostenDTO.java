package pizza.boundary.acl;

import pizza.entity.Pizza;

public class POSTBestellpostenDTO {
    public int menge;
    public long pizzaID;

    public POSTBestellpostenDTO(HtmlPizzaDTO htmlPizzaDTO){
        this.menge = htmlPizzaDTO.pMenge;
        long idz = htmlPizzaDTO.pNummer;
        this.pizzaID = idz;
    }
    @Override
    public String toString() {
        return "POSTBestellpostenDTO{" +
                "menge=" + menge +
                ", pizzaID=" + pizzaID +
                '}';
    }
}
