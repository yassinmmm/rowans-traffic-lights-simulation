/**
 *
 * @author Confucius
 */
package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {
    private BufferedImage img;

    public JImagePanel(BufferedImage img) {
        super();
        this.img = img;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, null);
    }
}
