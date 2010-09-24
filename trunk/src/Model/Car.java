/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Confucius
 */
public class Car extends JPanel {

    private BufferedImage pic;

    public Car() {
        try {
            pic = ImageIO.read(new File("C:/Users/Confucius/Documents/Uni/CP1300/Assignemnt 2/GUI_Traffic_Sim/Car.bmp"));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(pic, 0, 0, null);
    }
}
