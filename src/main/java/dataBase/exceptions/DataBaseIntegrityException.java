package dataBase.exceptions;

public class DataBaseIntegrityException extends RuntimeException{

    public DataBaseIntegrityException(){
        super();
    }

    public DataBaseIntegrityException(String errorMensage){
        super(errorMensage);
    }
}
