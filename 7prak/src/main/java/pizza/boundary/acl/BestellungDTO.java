package pizza.boundary.acl;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import pizza.entity.Bestellposten;
import pizza.entity.Bestellung;

import java.util.Collection;

public class BestellungDTO {
    public long bestellungId;
    public boolean bestellungFertig;
    public Collection<ReturnBestellpostenDTO> bestellpostenDTOList;

    public BestellungDTO(Bestellung bestellung) {
        this.bestellungId = bestellung.getBestellungID();
        this.bestellungFertig = bestellung.isBestellungFertig();
        for (Bestellposten b : bestellung.getBestellposten()) {
            ReturnBestellpostenDTO bestellpostenDTO = new ReturnBestellpostenDTO(b);
            bestellpostenDTOList.add(bestellpostenDTO);
        }
    }
}
