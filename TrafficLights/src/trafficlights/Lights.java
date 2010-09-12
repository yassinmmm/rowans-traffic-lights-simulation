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

    /**
     *
     * @return The current state (color) of the horizontal light
     */
    public static String HLight() {
        return HState;
    }

    /**
     *
     * @return The current state (color) of the vertical light
     */
    public static String VLight() {
        return VState;
    }

    /**
     * Cycles through the lights color pattern
     * Each tick increments the cycle by one
     */
    public static void tick() {
        if (tick < 6) {
            HState = "G";
            VState = "R";
        } else if (tick < 11) {
            HState = "O";
            VState = "R";
        } else if (tick < 17) {
            HState = "R";
            VState = "G";
        } else if (tick < 23) {
            HState = "R";
            VState = "O";
        } else {
            tick = 0;
            HState = "G";
            VState = "R";
        }
        ++tick;
    }
}
