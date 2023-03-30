module crud.sistemacrud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens controllers.main to javafx.fxml;
    exports controllers.main;

    opens controllers.cadastro to javafx.fxml;
    exports controllers.cadastro;

    opens controllers.verificar to javafx.fxml;
    exports controllers.verificar;

    opens controllers.lerInformacoes to javafx.fxml;
    exports controllers.lerInformacoes;

    opens controllers.atualizar to javafx.fxml;
    exports controllers.atualizar;

    opens controllers.deletar to javafx.fxml;
    exports controllers.deletar;

    opens controllers.gerarRelatorio to javafx.fxml;
    exports controllers.gerarRelatorio;
}