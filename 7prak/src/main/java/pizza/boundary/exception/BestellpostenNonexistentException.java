package pizza.boundary.exception;

public class BestellpostenNonexistentException extends Exception{
    public BestellpostenNonexistentException(String errorMessage){
        super(errorMessage);
    }
}
