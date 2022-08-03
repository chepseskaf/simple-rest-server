package com.chepseskaf.server;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AsciiArt {
    private String value;
    private int width = 80;
    private int height = 25;

    public AsciiArt(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        BufferedImage image = new BufferedImage(
                width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(value, 6,  ((int) (height * 0.67)));

        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < height; y++) {

            for (int x = 0; x < width; x++) {
                stringBuilder.append(image.getRGB(x, y) == -16777216 ? " " : "*");
            }

            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
