package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.dao.implentation.PlantDaoJDBC;
import model.entities.Plant;
import model.entities.enums.PlantConservationStatus;
import utils.Constraints;
import utils.Alerts;
import utils.ShowImage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InsertController implements Initializable {

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
    private Button insertButton;

    private void initializeComboBox(){
        ObservableList<PlantConservationStatus> items = FXCollections.observableArrayList(
                PlantConservationStatus.CRITICAL,
                PlantConservationStatus.ENDANGERED,
                PlantConservationStatus.VULNERABLE,
                PlantConservationStatus.NEAR_THREATENED,
                PlantConservationStatus.LEAST_CONCERN,
                PlantConservationStatus.DATA_DEFICIENT
        );
        conservationStatusComboBox.setItems(items);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Constraints.limitTextField(scientificNameTextField, 255);
        Constraints.limitTextFieldToLettersOnly(scientificNameTextField);
        Constraints.limitTextField(commonNameTextField, 255);
        Constraints.limitTextFieldToLettersOnly(commonNameTextField);
        Constraints.limitTextArea(descriptionTextArea, 1020);
        Constraints.limitTextField(habitatsTextField, 510);
        Constraints.limitTextFieldToLettersOnly(habitatsTextField);
        Constraints.limitTextField(originTextField, 255);
        Constraints.limitTextFieldToLettersOnly(originTextField);
        initializeComboBox();
    }

    private void imageChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        if(file != null)
            imageView.setImage(new Image(file.toURI().toString()));
    }

    @FXML
    private void imageViewAction(MouseEvent mouseEvent){
        if (mouseEvent.getButton() == MouseButton.PRIMARY)
            imageChooser();
        else
            ShowImage.showImagePopup(imageView.getImage());
    }

    private boolean formValidation(){
        boolean isFormValid = true;

        if (scientificNameTextField.getText().isEmpty()) {
            scientificNameTextField.getStyleClass().add("empty-field");
            isFormValid = false;
        } else {
            scientificNameTextField.getStyleClass().remove("empty-field");
        }

        if (conservationStatusComboBox.getValue() == null) {
            conservationStatusComboBox.getStyleClass().add("empty-field");
            isFormValid = false;
        } else {
            conservationStatusComboBox.getStyleClass().remove("empty-field");
        }

        if(imageView.getImage() == null){
            imageView.getStyleClass().add("empty-field");
            isFormValid = false;
        } else {
            imageView.getStyleClass().remove("empty-field");
        }

        return isFormValid;
    }

    private void cleanForm() {
        scientificNameTextField.clear();
        commonNameTextField.clear();
        descriptionTextArea.clear();
        habitatsTextField.clear();
        originTextField.clear();
        conservationStatusComboBox.setValue(null);
        imageView.setImage(null);
    }

    @FXML
    private void insert() {
        if(formValidation())
            try {
                PlantDaoJDBC plantDaoJDBC = PlantDaoJDBC.getInstance();
                plantDaoJDBC.insert(new Plant(
                        scientificNameTextField.getText(),
                        commonNameTextField.getText(),
                        descriptionTextArea.getText(),
                        habitatsTextField.getText(),
                        originTextField.getText(),
                        conservationStatusComboBox.getValue(),
                        imageView.getImage()
                ));
                Alerts.alertInformation("Plant successfully registered", "Operation completed", "");
                cleanForm();
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
    }
}