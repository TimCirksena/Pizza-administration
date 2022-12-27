package pizza.boundary.acl;

import pizza.entity.Bestellposten;

public class ReturnBestellpostenDTO {
    public long postenId;
    public int menge;
    public PizzaDTO pizzaDTO;

    public ReturnBestellpostenDTO(Bestellposten bestellposten){
        postenId = bestellposten.getPostenID();
        menge = bestellposten.getMenge();
        pizzaDTO = new PizzaDTO(bestellposten.getPizza());
    }

}
