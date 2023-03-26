package GUI.Exceptions;

public class FXMLNotFoundException extends RuntimeException{
    public FXMLNotFoundException(String errorMensage){
        super(errorMensage);
    }
}
