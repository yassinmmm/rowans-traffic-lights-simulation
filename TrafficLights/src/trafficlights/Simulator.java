/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Confucius
 */
public class Simulator {

    /**
     *
     * @param numTimes Number of times to simulate
     */
    public static void Simulate(int numTimes) {
        for (int i = 0; i < numTimes; ++i) {
            DoPossibleCars();
            Lights.tick();
            Grid.ShowGrid();
            MoveCars();
            SimModel.CheckCars();

            Thread t = new Thread();
            try {
                t.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void DoPossibleCars() {
        Random rand = new Random();

        int result = rand.nextInt(100);

        if (result < (SimModel.getHprob() * 100)) {
            result = rand.nextInt(SimModel.getHorLanes());
            if (!(Grid.getGrid()[Grid.MIDPOINT + result][0] instanceof Car)) {
                HorCar c = new HorCar(result);
                SimModel.addCar(c);
            }
        }

        result = rand.nextInt(100);

        if (result < (SimModel.getVProb() * 100)) {
            result = rand.nextInt(SimModel.getVertLanes());
            if (!(Grid.getGrid()[0][Grid.MIDPOINT + result] instanceof Car)) {
                VertCar c = new VertCar(result);
                SimModel.addCar(c);
            }
        }
    }

    private static void MoveCars() {
        for (Car c : SimModel.getCarList()) {
            c.Move();
        }
    }
}
