package pizza.boundary.exception;

public class NoActiveBestellungException extends Exception{
    public NoActiveBestellungException(String errorMessage){
        super(errorMessage);
    }
}
