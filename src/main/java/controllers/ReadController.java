package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.entities.enums.PlantConservationStatus;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadController implements Initializable {
    @FXML
    private TextField scientificNameTextField;

    @FXML
    private TextField commonNameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField habitatsTextField;

    @FXML
    private TextField originTextField;

    @FXML
    private ComboBox<PlantConservationStatus> conservationStatusComboBox;

    @FXML
    private Button findByScientificName;

    @FXML
    private Button findByCommonName;

    @FXML
    private Button findAll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        descriptionTextArea.setDisable(true);
        imageView.setDisable(true);
        habitatsTextField.setDisable(true);
        originTextField.setDisable(true);
        conservationStatusComboBox.setDisable(true);
    }

    @FXML
    private void read(){

    }
}
