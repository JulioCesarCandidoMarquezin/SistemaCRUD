package utils;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;

public class ImageChooser {

    public static Image imageChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fileChooser.showOpenDialog(null);
        return (file != null) ? new Image(file.toURI().toString()) : null;
    }
}
