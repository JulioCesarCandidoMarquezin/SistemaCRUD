package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import model.dao.PlantDao;
import model.dao.implentation.PlantDaoJDBC;
import model.entities.Plant;
import model.entities.enums.PlantConservationStatus;
import utils.Constraints;
import utils.ShowImage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadController implements Initializable {

    @FXML
    private AnchorPane readAnchorPane;

    @FXML
    private TextField scientificNameTextField;

    @FXML
    private TextField commonNameTextField;

    @FXML
    private TableView<Plant> tableView;

    @FXML
    private TableColumn<Plant, String> columnScientificName;

    @FXML
    private TableColumn<Plant, String> columnCommonName;

    @FXML
    private TableColumn<Plant, String> columnDescriptions;

    @FXML
    private TableColumn<Plant, String> columnHabitat;

    @FXML
    private TableColumn<Plant, String> columnOrigin;

    @FXML
    private TableColumn<Plant, PlantConservationStatus> columnConservationStatus;

    @FXML
    private TableColumn<Plant, Image> columnImage;

    private final PlantDao plantDao = PlantDaoJDBC.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        columnScientificName.setCellValueFactory(new PropertyValueFactory<>("scientificName"));
        columnCommonName.setCellValueFactory(new PropertyValueFactory<>("commonName"));
        columnDescriptions.setCellValueFactory(new PropertyValueFactory<>("descriptions"));
        columnHabitat.setCellValueFactory(new PropertyValueFactory<>("habitat"));
        columnOrigin.setCellValueFactory(new PropertyValueFactory<>("origin"));
        columnConservationStatus.setCellValueFactory(new PropertyValueFactory<>("conservationStatus"));
        columnImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        columnImage.setCellFactory(param -> new TableCell<>() {
            private final ImageView imageView = new ImageView();

            {
                setGraphic(imageView);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                imageView.setOnMouseClicked(event -> {
                    Image image = getItem();
                    if (image != null) {
                        ShowImage.showImagePopup(image);
                    }
                });
            }

            @Override
            protected void updateItem(Image image, boolean empty) {
                super.updateItem(image, empty);
                if (empty || image == null) {
                    imageView.setImage(null);
                } else {
                    imageView.setImage(image);
                    imageView.setFitHeight(50);
                    imageView.setFitWidth(50);
                }
            }
        });
        tableView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                TablePosition<?, ?> position = tableView.getSelectionModel().getSelectedCells().get(0);
                int rowIndex = position.getRow();
                TableColumn<?, ?> tableColumn = position.getTableColumn();

                if (tableColumn == columnImage) {
                    Plant plant = tableView.getItems().get(rowIndex);
                    Image image = plant.getImage();
                    System.out.println("Cell clicked at row " + rowIndex + ", column " + tableColumn.getText());
                    if(image != null) ShowImage.showImagePopup(image);
                    tableView.getSelectionModel().clearSelection();
                }
            }
        });
        Constraints.limitTextFieldToLettersOnly(scientificNameTextField);
        Constraints.limitTextFieldToLettersOnly(commonNameTextField);
    }

    private String formatStringToQuery(String input) {
        return Constraints.removeAccents(Constraints.removeSpaces(input));
    }

    @FXML
    private void query(ActionEvent event) throws SQLException, IOException {
        String consultType = ((Button) event.getSource()).getUserData().toString();
        List<Plant> plants = switch (consultType) {
            case "findByScientificName" -> plantDao.findByScientificName(formatStringToQuery(scientificNameTextField.getText()));
            case "findByCommonName" -> plantDao.findByCommonName(formatStringToQuery(commonNameTextField.getText()));
            case "findAll" -> plantDao.findAll();
            default -> new ArrayList<>();
        };

        tableView.getColumns().clear();
        tableView.setItems(FXCollections.observableList(plants));
        tableView.getColumns().addAll(
                columnScientificName,
                columnCommonName,
                columnDescriptions,
                columnHabitat,
                columnOrigin,
                columnConservationStatus,
                columnImage
        );
    }
}
