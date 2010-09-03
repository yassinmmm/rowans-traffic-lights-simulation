/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public class Lights {

    private static String HState;
    private static String VState;
    private static int tick = 1;

    public static String HLight() {
        return HState;
    }

    public static String VLight() {
        return VState;
    }

    public static void tick() {
        if (tick < 6) {
            HState = "G";
            VState = "R";
        } else if (tick < 11) {
            HState = "O";
            VState = "R";
        } else if (tick < 16) {
            HState = "R";
            VState = "G";
        } else if (tick < 21) {
            HState = "R";
            VState = "O";
        } else {
            tick = 0;
        }
        ++tick;
    }
}
