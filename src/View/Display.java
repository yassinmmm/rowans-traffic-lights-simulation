/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Confucius
 */
public class Display extends JFrame {

    JImagePanel background;

    public Display(BufferedImage bg) {
        background = new JImagePanel(bg);
        this.add(background);
        this.setPreferredSize(new Dimension(bg.getWidth(), bg.getHeight()));
        this.setVisible(true);
        this.pack();     
    }

    public void updateComponents(BufferedImage[] imgArr) {
        this.remove(background);
        JImagePanel temp = new JImagePanel(imgArr[0]);
        background = temp;
        this.add(background);
        this.pack();
        this.setPreferredSize(new Dimension(imgArr[0].getWidth(), imgArr[0].getHeight()));
    }
}