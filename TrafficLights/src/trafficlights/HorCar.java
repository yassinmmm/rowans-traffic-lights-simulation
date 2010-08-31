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
public class HorCar extends Car {
    public HorCar(int lane) {
        Gridcol = 0;

        setRowLoc(lane);
    }

    private void setRowLoc(int r) {
        Gridrow = Grid.MIDPOINT + r + 1;
    }

    public boolean checkOnRoad() {
        if (Gridrow > Grid.MIDPOINT + SimModel.getHorLanes() ||
                Gridcol == SimModel.gridSize) {
            return false;
        }
        return true;
    }

    public void MoveForward() {
        if (Lights.HLight().equals("G")) {                                              // If light is GREEN
            this.moving = "GO";                                                             // GO
            ++Gridcol;
        } else {                                                                        // Else
            if (Gridcol <= Grid.MIDPOINT - 1) {                                             // If before intersection
                if (Grid.getGrid()[Gridrow][Gridcol + 1] instanceof Car                     // If there is a STOPPED car
                        && Grid.getGrid()[Gridrow][Gridcol + 1].equals("STOPPED")
                        || Gridcol == Grid.MIDPOINT - 1) {                                      // or at the intersection
                    this.moving = "STOPPED";                                                        // STOP
                } else {                                                                        // Else
                    this.moving = "GO";                                                             // GO
                    ++Gridcol;
                }
            } else {                                                                        // Else
                this.moving = "GO";                                                             // GO
                ++Gridcol;
            }
        }
    }

    public int[] loc() {
        loc[0] = Gridrow;
        loc[1] = Gridcol;
        return loc;
    }
}
