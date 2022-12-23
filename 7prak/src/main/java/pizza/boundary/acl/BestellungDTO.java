package pizza.boundary.acl;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import java.util.Collection;

public class BestellungDTO {
    public long bestellungId;
    public boolean bestellungFertig;
    public Collection<ReturnBestellpostenDTO> bestellpostenDTOList;
}
