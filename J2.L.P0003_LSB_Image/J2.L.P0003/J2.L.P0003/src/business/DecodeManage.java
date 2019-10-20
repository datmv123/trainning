/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Drol
 */
public class DecodeManage {

    private BufferedImage stegoImage;

    public DecodeManage() {

    }

    public BufferedImage getStegoImage() {
        return stegoImage;
    }

    public void setStegoImage(BufferedImage stegoImage) {
        this.stegoImage = stegoImage;
    }

    public String decodeMessage() {
        String binMessage = "";
        boolean findStart = false;
        //loop all pixels of image
        for (int x = 0; x < stegoImage.getWidth(); x++) {
            for (int y = 0; y < stegoImage.getHeight(); y++) {
                int pixel_rgb = stegoImage.getRGB(x, y);
                binMessage += getLSBBitsFromPixel(pixel_rgb);
                //check 9 first bits of bin message get from pixels to make sure image contain message
                if (binMessage.length() >= 9) {
                    if (findStart == false) {
                        String lastGroup = binMessage.substring(binMessage.length() - 9);
                        if (lastGroup.equals("001111111")) {
                            findStart = true;
                            binMessage = "";
                        } else {
                            return "";
                        }
                    } else {
                        String lastGroup = binMessage.substring(binMessage.length() - 9);
                        if (lastGroup.equals("001111111")) {
                            binMessage = binMessage.substring(0, binMessage.length() - 9);
                            String message = binMessageToMessage(binMessage);
                            return message;
                        }
                    }
                }
            }
        }
        return "";
    }

    /**
     * Get 3 last bit of each r,g,b of rgb of pixel
     *
     * @param pixel_rgb rgb of pixel
     * @return 3 last bit of r,b,g in String.
     */
    private String getLSBBitsFromPixel(int pixel_rgb) {
        String result = "";
        Color color = new Color(pixel_rgb);
        //get r,g,b
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        //get last bit and append to result
        result += (r & 0x01) + "";
        result += (g & 0x01) + "";
        result += (b & 0x01) + "";

        return result;
    }

    /**
     * Change binary message to 'original' message .Binary message length must
     * mod 8 is 0
     *
     * @param binMessage binary message
     * @return message
     */
    private String binMessageToMessage(String binMessage) {
        String result = "";
        try {
            while (binMessage.length() > 0) {
                //take every 8 bit of binary message and change to chracter. after that, append to result
                String character = binMessage.substring(0, 8);
                result += (char) Integer.parseInt(character, 2) + "";
                binMessage = binMessage.substring(8);
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return result;
    }
}
