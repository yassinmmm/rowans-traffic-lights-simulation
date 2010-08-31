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
        if (Lights.VLight().equals("G")) {                                              // If light is GREEN
            this.moving = "GO";                                                             // GO
            ++Gridrow;
        } else {                                                                        // Else
            if (Gridrow <= Grid.MIDPOINT - 1) {                                             // If before intersection
                if (Grid.getGrid()[Gridrow + 1][Gridcol] instanceof Car                     // If there is a STOPPED car
                        && Grid.getGrid()[Gridrow + 1][Gridcol].equals("STOPPED")
                        || Gridrow == Grid.MIDPOINT - 1) {                                      // or at the intersection
                    this.moving = "STOPPED";                                                        // STOP
                } else {                                                                        // Else
                    this.moving = "GO";                                                             // GO
                    ++Gridrow;
                }
            } else {                                                                        // Else
                this.moving = "GO";                                                             // GO
                ++Gridrow;
            }
        }
    }

    public int[] loc() {
        loc[0] = Gridrow;
        loc[1] = Gridcol;
        return loc;
    }
}
