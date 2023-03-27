package GUI.Exceptions;

public class FXMLLoadException extends RuntimeException{

    public FXMLLoadException(){
        super();
    }

    public FXMLLoadException(String erroMensage){
        super(erroMensage);
    }
}
