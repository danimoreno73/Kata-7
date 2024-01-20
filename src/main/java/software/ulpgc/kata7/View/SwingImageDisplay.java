package software.ulpgc.kata7.View;


import software.ulpgc.kata7.Model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image image;

    @Override
    public void show(Image image) {

        this.image = image;
        repaint();

    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void paint(Graphics g){

            g.drawImage(
                    imageOf(image.name()),
                    0,
                    0,
                    this.getWidth(),
                    this.getHeight(),
                    null);

    }
    private BufferedImage imageOf(String name) {
        try {
            return ImageIO.read(new File(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
