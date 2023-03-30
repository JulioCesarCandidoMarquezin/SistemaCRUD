package utils;

import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageByte {
    public static byte[] imageToByteArrayConverter(Image image) throws IOException, NullPointerException{
        BufferedImage bufferedImage = ImageIO.read(new File(image.getUrl()));
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        return data.getData();
    }

    public static Image byteArrayToImageConverter(byte[] imageBytes) throws NullPointerException{
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        return new Image(inputStream);
    }
}
