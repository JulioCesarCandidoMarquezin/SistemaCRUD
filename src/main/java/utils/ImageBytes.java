package utils;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageBytes {
    public static byte[] imageToByteArrayConverter(Image image) throws IOException, NullPointerException{
        if(image == null) return null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bufferedImage, "png", outputStream);
        return outputStream.toByteArray();
    }

    public static Image byteArrayToImageConverter(byte[] imageBytes) throws IOException, NullPointerException{
        if(imageBytes == null) return null;
        ByteArrayInputStream byteArrayInputStreams = new ByteArrayInputStream(imageBytes);
        BufferedImage bufferedImage = ImageIO.read(byteArrayInputStreams);
        return SwingFXUtils.toFXImage(bufferedImage, null);
    }
}