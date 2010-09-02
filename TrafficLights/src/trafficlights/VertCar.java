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
    public VertCar(int lane) {
        Gridrow = 0;

        setColLoc(lane);
    }

    private void setColLoc(int c) {
        Gridcol = Grid.MIDPOINT + c + 1;
    }

    public boolean checkOnRoad() {
        if (Gridcol > Grid.MIDPOINT + SimModel.getVertLanes() ||
                Gridrow == SimModel.gridSize) {
            return false;
        }
        return true;
    }

    public void MoveForward() {
        if (Lights.VLight().equals("G")) {                                          // If lights are green
            this.moving = "GO";                                                         // GO
            ++Gridrow;
            return;
        }

        if (Gridrow == Grid.MIDPOINT - 1) {                                         // If at intersection
            this.moving = "STOPPED";                                                    // STOP
            return;
        }

        if (Gridrow < SimModel.gridSize - 1 // If before end of road
                && Grid.getGrid()[Gridrow+1][Gridcol] instanceof Car          // If car infront & STOPPED
                && Grid.getGrid()[Gridrow+1][Gridcol].equals("STOPPED")) {

            if (!(Grid.getGrid()[Gridrow][Gridcol+1] instanceof Car)
                    && Gridcol + 1 <= Grid.MIDPOINT + SimModel.getVertLanes()) { // Check if can change lanes down

                this.moving = "STOPPED";                                           // Change lanes down
                ++Gridcol;
                return;
            }

//            if (!(Grid.getGrid()[Gridrow - 1][Gridcol] instanceof Car)
//                    && Gridrow - 1 > Grid.MIDPOINT) {                           // Check if can change lanes up
//
//                this.moving = "STOPPED";                                           // Change lanes up
//                --Gridrow;
//                return;
//            }

            this.moving = "STOPPED";                                                // Otherwise STOP
            return;
        }

        this.moving = "GO";                                                         // If lights are not Green, not at the intersection
        ++Gridrow;                                                                  // , not a car that is stopped infront
        // then move forwards
    }

    public int[] loc() {
        loc[0] = Gridrow;
        loc[1] = Gridcol;
        return loc;
    }
}
