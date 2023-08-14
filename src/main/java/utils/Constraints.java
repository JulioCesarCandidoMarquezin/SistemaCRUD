package utils;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.Normalizer;

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

    public static String removeAccents(String input) {
        if (input == null) return null;
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    public static String removeSpaces(String input) {
        if (input == null) return null;
        return input.replaceAll(" ", "");
    }
}
