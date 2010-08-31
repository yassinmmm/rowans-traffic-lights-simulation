/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trafficlights;

import java.util.Random;

/**
 *
 * @author Confucius
 */
public class HorCar extends Car{

    private static int index = 0;
    public int ID;

    public HorCar() {
        ++index;
        this.ID = index;

        Gridcol = 0;

        Random rand = new Random();
        int lane = rand.nextInt(SimModel.getHorLanes());
        setRowLoc(lane);
    }

    public void setRowLoc(int r) {
        Gridrow = Grid.MIDPOINT + r + 1;
    }

    public boolean checkOnRoad() {
        if (Gridrow > Grid.MIDPOINT + SimModel.getHorLanes()) {
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
