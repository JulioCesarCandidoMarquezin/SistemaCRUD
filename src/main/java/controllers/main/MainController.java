package controllers.main;

import controllers.exceptions.FXMLLoadException;
import controllers.exceptions.FXMLNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class MainController {

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

    public void onButtonCadastrarAction(){
        loadFXML("/controllers/cadastro/Cadastro.fxml");
    }

    public void onButtonVerificarAction(){
        loadFXML("/controllers/verificar/Verificar.fxml");
    }

    public void onButtonLerInformacoesAction(){
        loadFXML("/controllers/lerInformacoes/LerInformacoes.fxml");
    }

    public void onButtonAtualizarAction(){
        loadFXML("/controllers/atualizar/Atualizar.fxml");
    }

    public void onButtonDeletarAction(){
        loadFXML("/controllers/deletar/Deletar.fxml");
    }

    public void onButtonGerarRelatorioAction(){
        loadFXML("/controllers/gerarRelatorio/GerarRelatorio.fxml");
    }

    @FXML
    public synchronized void loadFXML(String caminhoRelativoAoResources){
        try {
            Pane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(caminhoRelativoAoResources)));
            fxml.getChildren().setAll(anchorPane);
        }
        catch (IOException IOE){
            throw new FXMLLoadException("Não foi possível carregar o FXML");
        }
        catch (NullPointerException NPE){
            throw new FXMLNotFoundException("FXML no caminho " + caminhoRelativoAoResources + " não foi encontrado");
        }
    }

}