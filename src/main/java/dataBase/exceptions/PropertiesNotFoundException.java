package dataBase.exceptions;

public class PropertiesNotFoundException extends RuntimeException{
    public PropertiesNotFoundException(){
        super();
    }

    public PropertiesNotFoundException(String errorMensage){
        super(errorMensage);
    }
}
