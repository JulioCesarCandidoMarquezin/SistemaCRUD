module crud.sistemacrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens GUI.Main to javafx.fxml;
    exports GUI.Main;

    opens GUI.Cadastro to javafx.fxml;
    exports GUI.Cadastro;

    opens GUI.Verificar to javafx.fxml;
    exports GUI.Verificar;

    opens GUI.LerInformacoes to javafx.fxml;
    exports GUI.LerInformacoes;

    opens GUI.Atualizar to javafx.fxml;
    exports GUI.Atualizar;

    opens GUI.Deletar to javafx.fxml;
    exports GUI.Deletar;

    opens GUI.GerarRelatorio to javafx.fxml;
    exports GUI.GerarRelatorio;
}