package controllers.exceptions;

public class FXMLNotFoundException extends RuntimeException{

    public FXMLNotFoundException(){
        super();
    }

    public FXMLNotFoundException(String errorMensage){
        super(errorMensage);
    }
}
