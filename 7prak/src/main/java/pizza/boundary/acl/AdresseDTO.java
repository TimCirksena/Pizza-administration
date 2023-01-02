package pizza.boundary.acl;

import pizza.entity.Adresse;

public class AdresseDTO {
    public String plz;
    public String ort;
    public String strasseUndHausnummer;

    public AdresseDTO(){}
    public AdresseDTO(Adresse adresse){
        this.plz = adresse.getPlz();
        this.ort = adresse.getOrt();
        this.strasseUndHausnummer = adresse.getStrasseUndHausnummer();
    }
}
