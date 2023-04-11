package controllers.cadastro;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import model.dao.PlantaDao;
import model.dao.implentation.PlantaDaoJDBC;
import model.entities.enums.ConservationStatus;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    private AnchorPane painelCadastro;

    @FXML
    private TextField scientificNameTextField;

    @FXML
    private TextField commonNameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ImageView imageView;

    @FXML
    private TextField HabitatsTextField;

    @FXML
    private TextField originTextField;

    @FXML
    private ComboBox<ConservationStatus> conservationStatusComboBox;

    @FXML
    private Button cadastrarButton;

    private PlantaDao plantaDaoJDBC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
          initializeComboBox();
    }

    public void initializeComboBox(){
        ObservableList<ConservationStatus> itens = FXCollections.observableArrayList(
                ConservationStatus.VULNERABLE,
                ConservationStatus.CRITICAL,
                ConservationStatus.DATA_DEFICIENT,
                ConservationStatus.ENDANGERED,
                ConservationStatus.LEAST_CONCERN,
                ConservationStatus.NEAR_THREATENED
        );
        conservationStatusComboBox.setItems(itens);
    }

    public void imageChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecionar imagem");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagens", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            imageView.setImage(new Image(file.toURI().toString()));
        }
    }

    public void inicialize(){
        plantaDaoJDBC = new PlantaDaoJDBC();
    }
}
