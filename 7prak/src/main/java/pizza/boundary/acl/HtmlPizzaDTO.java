package pizza.boundary.acl;

public class HtmlPizzaDTO {
    public int pNummer;
    public int pMenge;



    @Override
    public String toString() {
        return "HtmlPizzaDTO{" +
                "pNummer=" + pNummer +
                ", pMenge=" + pMenge +
                '}';
    }
}
