/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;


/**
 *
 * @author Confucius
 */
public class HorCar extends Car {

    /**
     *
     * @param lane Which lane to spawn the car in
     */
    public HorCar(int lane) {
        Gridcol = 0;

        setRowLoc(lane);
    }

    private void setRowLoc(int r) {
        Gridrow = Grid.MIDPOINT + r + 1;
    }

    public boolean checkOnRoad() {
        if (Gridrow > Grid.MIDPOINT + SimModel.getHorLanes()
                || Gridcol == SimModel.GRID_SIZE) {
            return false;
        }
        return true;
    }

    public void Move() {
        if (Lights.HLight().equals("G")) {                                          // If lights are green
            this.moving = "GO";                                                         // GO
            ++Gridcol;
            return;
        }

        if (Gridcol == Grid.MIDPOINT - 1) {                                         // If at intersection
            this.moving = "STOPPED";                                                    // STOP
            return;
        }

        if (Gridcol < SimModel.GRID_SIZE - 1 // If before end of road
                && Grid.getGrid()[Gridrow][Gridcol + 1] instanceof Car          // If car infront & STOPPED
                && Grid.getGrid()[Gridrow][Gridcol + 1].equals("STOPPED")) {

            if (!(Grid.getGrid()[Gridrow + 1][Gridcol] instanceof Car)
                    && Gridrow + 1 <= Grid.MIDPOINT + SimModel.getHorLanes()) { // Check if can change lanes down

                this.moving = "STOPPED";                                           // Change lanes down
                ++Gridrow;
                return;
            }

            this.moving = "STOPPED";                                                // Otherwise STOP
            return;
        }

        this.moving = "GO";                                                         // If lights are not Green, not at the intersection
        ++Gridcol;                                                                  // , not a car that is stopped infront
                                                                                    // then move forwards
    }

    public int[] loc() {
        loc[0] = Gridrow;
        loc[1] = Gridcol;
        return loc;
    }
}
