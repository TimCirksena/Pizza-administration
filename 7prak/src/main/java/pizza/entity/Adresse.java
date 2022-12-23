package pizza.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Cacheable
public class Adresse {
    @Column
    private String plz;
    @Column
    private String ort;
    @Column @Id
    private String strasseUndHausnummer;

    public Adresse(){}

    public Adresse(String plz, String ort, String strasseUndHausnummer){
        this.plz = plz;
        this.ort = ort;
        this.strasseUndHausnummer = strasseUndHausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getStrasseUndHausnummer() {
        return strasseUndHausnummer;
    }

    public void setStrasseUndHausnummer(String strasseUndHausnummer) {
        this.strasseUndHausnummer = strasseUndHausnummer;
    }
}
