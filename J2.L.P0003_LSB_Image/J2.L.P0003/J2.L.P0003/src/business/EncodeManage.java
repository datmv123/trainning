/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Drol
 */
public class EncodeManage {

    //originale image.
    private BufferedImage originalImage;
    //stego image
    private BufferedImage stegoImage;
    //keep state that stego-image is saved or not. true mead saved
    private boolean savedStego = true;
    //keep file extension of original image
    private String imageExtension = "";

    public EncodeManage() {

    }

    public String getImageExtension() {
        return imageExtension;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }

    public boolean isSavedStego() {
        return savedStego;
    }

    public void setSavedStego(boolean savedStego) {
        this.savedStego = savedStego;
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(BufferedImage originalImage) {
        this.originalImage = originalImage;
    }

    public BufferedImage getStegoImage() {
        return stegoImage;
    }

    public void setStegoImage(BufferedImage stegoImage) {
        this.stegoImage = stegoImage;
    }

    public void encodeMessage(String message) {
        stegoImage = originalImage;
        String binMessage = stringToBinary(message);
        //because 1 pixel contains 3 bit binary
        //make sure that binary message length mod by 3 is 0
        while (binMessage.length() % 3 != 0) {
            binMessage += "0";
        }
        //take the mark to know where message begin and end
        binMessage = "001111111" + binMessage + "001111111";
        //change binary message to array
        char charsBinMessage[] = binMessage.toCharArray();
        int imageWidth = stegoImage.getWidth();
        int imageHeight = stegoImage.getHeight();
        int count = 0;
        //get all pixels of image because each pixel has (x,y) position
        for (int x = 0; x < imageWidth; x++) {
            for (int y = 0; y < imageHeight; y++) {
                int rgb = stegoImage.getRGB(x, y);
                Color color = new Color(rgb);
                //
                int a = color.getAlpha();
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                //encode binary message to r,g,b values. change last bit of each r,g,b
                r = (charsBinMessage[count++] == '0') ? (r & 0xFE) : (r | 0x01);
                g = (charsBinMessage[count++] == '0') ? (g & 0xFE) : (g | 0x01);
                b = (charsBinMessage[count++] == '0') ? (b & 0xFE) : (b | 0x01);

                //new rgb after encode
                rgb = (a << 24) | (r << 16) | (g << 8) | (b);
                //set back rgb to image
                stegoImage.setRGB(x, y, rgb);
                //check if message is encode full to image.
                if (count == charsBinMessage.length) {
                    return;
                }
            }
        }
    }

    /**
     * Change String to binary string
     *
     * @param txt original String
     * @return binary String of original String
     */
    private String stringToBinary(String txt) {
        String result = "";
        char chars[] = txt.toCharArray();
        //loop all char in original string
        for (char c : chars) {
            String bin = Integer.toBinaryString(c);
            //make sure every char change to binary will have 8 bit
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            result += bin;
        }
        return result;
    }

    /**
     * Resize image
     *
     * @param image original image
     * @param widthSize width of image that expected
     * @param heigthSize height size of image that expected
     * @return new image after resize
     */
    public Image resizeImage(BufferedImage image, int widthSize, int heigthSize) {
        int width = image.getWidth();
        int height = image.getHeight();
        int dx = 0, dy = 0;
        if ((double) widthSize / heigthSize > (double) width / height) {
            dy = heigthSize;
            dx = dy * width / height;
        } else {
            dx = widthSize;
            dy = dx * height / width;
        }

        return image.getScaledInstance(dx, dy, image.SCALE_SMOOTH);
    }
}
