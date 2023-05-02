package views;

import javafx.scene.control.Alert;

public class Alerts {
    private static Alert alert;
    
    public static void alertError(String mensage, String title, String header){
        alert = new Alert(Alert.AlertType.ERROR, mensage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        mostraAlert();
    }

    public static void alertWarning(String mensage, String title, String header){
        alert = new Alert(Alert.AlertType.WARNING, mensage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        mostraAlert();
    }
    public static void alertInformation(String mensage, String title, String header){
        alert = new Alert(Alert.AlertType.INFORMATION, mensage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        mostraAlert();
    }
    public static void alertConfirmation(String mensage, String title, String header){
        alert = new Alert(Alert.AlertType.CONFIRMATION, mensage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        mostraAlert();
    }
    public static void alertNone(String mensage, String title, String header){
        alert = new Alert(Alert.AlertType.NONE, mensage);
        alert.setTitle(title);
        alert.setHeaderText(header);
        mostraAlert();
    }
    
    private static void mostraAlert(){
        alert.show();
    }
}
