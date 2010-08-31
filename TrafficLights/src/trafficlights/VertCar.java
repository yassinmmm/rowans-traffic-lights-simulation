/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Random;

/**
 *
 * @author jc223892
 */
public class VertCar extends Car {

    private static int index = 0;
    public int ID;

    public VertCar() {
        ++index;
        this.ID = index;

        Gridrow = 0;

        Random rand = new Random();
        int lane = rand.nextInt(SimModel.getVertLanes());
        setColLoc(lane);
    }

    private void setColLoc(int c) {
        Gridcol = Grid.MIDPOINT + c + 1;
    }

    public boolean checkOnRoad() {
        if (Gridcol > Grid.MIDPOINT + SimModel.getVertLanes()) {
            return false;
        }
        return true;
    }

    public int[] loc() {
        loc[0] = Gridrow;
        loc[1] = Gridcol;
        return loc;
    }
}
