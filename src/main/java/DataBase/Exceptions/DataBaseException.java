package DataBase.Exceptions;

public class DataBaseException extends RuntimeException{
    public DataBaseException(){
        super();
    }

    public DataBaseException(String errorMensage){
        super(errorMensage);
    }
}
