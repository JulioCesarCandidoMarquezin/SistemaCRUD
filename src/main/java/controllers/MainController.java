package controllers;

import controllers.exceptions.FXMLLoadException;
import controllers.exceptions.FXMLNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane root;

    @FXML
    private Pane fxml;

    @FXML
    private GridPane paineButtons;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonInsert;

    @FXML
    private Button buttonRead;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonGenerateReport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private synchronized void loadFXML(ActionEvent event){
        String fxmlName = ((Button) (event.getSource())).getUserData().toString();
        String fxmlPath = "/fxml/" + fxmlName + ".fxml";
        try {
            Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
            fxml.getChildren().setAll(pane);
        }
        catch (IOException IOE){
            throw new FXMLLoadException("Failed to load the FXML");
        }
        catch (NullPointerException NPE){
            throw new FXMLNotFoundException("FXML at path " + fxmlPath + " was not found");
        }
    }
}