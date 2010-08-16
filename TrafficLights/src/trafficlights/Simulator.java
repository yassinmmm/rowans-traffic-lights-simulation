/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
/**
 *
 * @author jc223892
 */
public class Simulator {
    Random rand = new Random();
    Timer time = new Timer();

    public void Run() {
        for (int i = 0; i < 10; ++i) {
            
            try {
                time.wait(1000);               
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
