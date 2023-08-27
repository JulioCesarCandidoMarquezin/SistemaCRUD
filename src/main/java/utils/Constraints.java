package utils;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Constraints {
    public static void limitTextField(TextField textField, int maxLength) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > maxLength) {
                textField.setText(oldValue);
            }
        });
    }

    public static void limitTextArea(TextArea textArea, int maxLength) {
        textArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > maxLength) {
                textArea.setText(oldValue);
            }
        });
    }

    public static void limitTextFieldToLettersOnly(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("[a-zA-ZÀ-ÿ\\s]*")) {
                textField.setText(oldValue);
            }
        });
    }
}
