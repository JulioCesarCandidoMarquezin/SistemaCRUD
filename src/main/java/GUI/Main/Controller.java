package GUI.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    BorderPane root = new BorderPane();

    @FXML
    Pane fxml = new AnchorPane();

    @FXML
    GridPane painelDeBotoes = new GridPane();

    @FXML
    Button botaoCadastrar = new Button();

    @FXML
    Button botaoVerificar = new Button();

    @FXML
    Button botaoLerInformacoes = new Button();

    @FXML
    Button botaoAtualizarInformacoes = new Button();

    @FXML
    Button botaoDeletar = new Button();

    @FXML
    Button botaoGerarRelatorio = new Button();

    @FXML
    public void trocarPaneParaCadastro() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Cadastro/Cadastro.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }

    @FXML
    public void trocarPaneParaVerificar() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Verificar/Verificar.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }

    @FXML
    public void trocarPaneParaLerInformacoes() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/LerInformacoes/LerInformacoes.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }

    @FXML
    public void trocarPaneParaAtualizar() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Atualizar/Atualizar.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }

    @FXML
    public void trocarPaneParaDeletar() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Deletar/Deletar.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }

    @FXML
    public void trocarPaneParaGerarRelatorio() throws IOException{
        Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/GerarRelatorio/GerarRelatorio.fxml")));
        fxml.getChildren().setAll(anchorPane);
    }
}