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
public class Simulator {

    public static void Simulate(int numTimes) {
        for (int i = 0; i < numTimes; ++i) {
            DoPossibleCars();
            Grid.ShowGrid();
        }
    }

    private static void DoPossibleCars() {
        Random rand = new Random();

        int result = rand.nextInt(100);

        if (result > (SimModel.getHprob() * 100)) {
            HorCar c = new HorCar();
            SimModel.addCar(c);
        }

        if (result > (SimModel.getVProb() * 100)) {
            VertCar c = new VertCar();
            SimModel.addCar(c);
        }
    }
}
