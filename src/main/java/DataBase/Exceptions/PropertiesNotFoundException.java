package DataBase.Exceptions;

public class PropertiesNotFoundException extends RuntimeException{
    public PropertiesNotFoundException(){
        super();
    }

    public PropertiesNotFoundException(String errorMensage){
        super(errorMensage);
    }
}
