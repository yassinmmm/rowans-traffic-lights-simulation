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
     * @param rate The rate at which the lights change color.
     * (each rate = 1 car)
     */
    public static void tick(int rate) {
        if (tick < rate) {
            HState = "G";
            VState = "R";
        } else if (tick < rate * 2) {
            HState = "O";
            VState = "R";
        } else if (tick < rate * 3) {
            HState = "R";
            VState = "G";
        } else if (tick < rate * 4) {
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
