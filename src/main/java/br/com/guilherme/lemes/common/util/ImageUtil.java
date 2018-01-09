package br.com.guilherme.lemes.common.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageUtil {

    public static Image getImage(String path) {
        try {
            URL url = ImageUtil.class.getResource(path);
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage byteArrayToImage(byte[] byteArray) throws IOException {
        if (byteArray == null)
            return null;

        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(byteArray));
        BufferedImage createdImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) createdImage.getGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        return createdImage;
    }

    public static BufferedImage byteArrayToImage(byte[] byteArray, int width, int height) throws IOException {
        if (byteArray == null)
            return null;

        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(byteArray));
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage createdImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) createdImage.getGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();
        return createdImage;
    }

    public static byte[] imageToByteArray(BufferedImage bufferedImage) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return byteArrayOutputStream.toByteArray();
    }

    public static boolean validateImage(byte[] response) {
        return response != null
                    && (response[0] & 0xFF) == 0xFF
                    && (response[1] & 0xFF) == 0xD8
                    && (response[response.length - 2] & 0xFF) == 0xFF
                    && (response[response.length - 1] & 0xFF) == 0xD9;
    }
}
