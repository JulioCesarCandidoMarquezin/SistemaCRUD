package utils;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ShowImage {
    private static final Stage stage = new Stage();

    public static void showImagePopup(Image image) {
        ImageView imageView = new ImageView(image);
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root);

        if(image.getHeight() > getMaxHeight() || image.getWidth() > getMaxWidth()) {
            imageView.setFitHeight(getMaxHeight());
            imageView.setFitWidth(getMaxWidth());
        }
        imageView.fitWidthProperty().bind(scene.widthProperty());
        imageView.fitHeightProperty().bind(scene.heightProperty());
        imageView.setPreserveRatio(true);

        stage.setScene(scene);
        stage.setTitle("Image");
        stage.centerOnScreen();
        stage.show();
    }

    private static double getMaxWidth() {
        return Screen.getPrimary().getVisualBounds().getWidth();
    }

    private static double getMaxHeight() {
        return Screen.getPrimary().getVisualBounds().getHeight();
    }

}
