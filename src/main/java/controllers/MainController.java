package controllers;

import controllers.exceptions.FXMLLoadException;
import controllers.exceptions.FXMLNotFoundException;
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
        onButtonHomeAction();
    }

    @FXML
    private void onButtonHomeAction(){
        loadFXML("/fxml/Home.fxml");
    }

    @FXML
    private void onButtonInsertAction(){
        loadFXML("/fxml/Insert.fxml");
    }

    @FXML
    private void onButtonReadAction(){
        loadFXML("/fxml/Read.fxml");
    }

    @FXML
    private void onButtonUpdateAction(){
        loadFXML("/fxml/Update.fxml");
    }

    @FXML
    private void onButtonDeleteAction(){
        loadFXML("/fxml/Delete.fxml");
    }

    @FXML
    private void onButtonGenerateReport(){
        loadFXML("/fxml/GenerateReport.fxml");
    }

    @FXML
    private synchronized void loadFXML(String relativePathToResources){
        try {
            Pane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(relativePathToResources)));
            fxml.getChildren().setAll(pane);
        }
        catch (IOException IOE){
            throw new FXMLLoadException("Failed to load the FXML");
        }
        catch (NullPointerException NPE){
            throw new FXMLNotFoundException("FXML at path " + relativePathToResources + " was not found");
        }
    }
}