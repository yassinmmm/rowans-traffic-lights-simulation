/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.ArrayList;

/**
 *
 * @author Confucius
 */
public class SimModel {

    private static int HorLanes = 2;
    private static int VertLanes = 2;
    private static double HProb = 0.55;
    private static double VProb = 0.4;
    private static ArrayList<Car> CarList = new ArrayList<Car>();
    public static final int LIGHTS_TICK_RATE = 8;
    /**
     * Determines the overall size of the Grid/Simulation
     */
    public static final int GRID_SIZE = 30;

    /**
     *
     * @param Hnum Number of horizontal lanes to set
     */
    public static void setHorLanes(int Hnum) {
        HorLanes = Hnum;
        CheckCars();
    }

    /**
     *
     * @return Number of horizontal lanes
     */
    public static int getHorLanes() {
        return HorLanes;
    }

    /**
     *
     * @param Vnum Number of vertical lanes to set
     */
    public static void setVertLanes(int Vnum) {
        VertLanes = Vnum;
        CheckCars();
    }

    /**
     *
     * @return Number of vertical lanes
     */
    public static int getVertLanes() {
        return VertLanes;
    }

    /**
     *
     * @param Hprob Probability of a car spawning on the horizontal street
     */
    public static void setHProb(double Hprob) {
        HProb = Hprob;
    }

    /**
     *
     * @return Probability of a car spawning on the horizontal street
     */
    public static double getHprob() {
        return HProb;
    }

    /**
     *
     * @param Vprob Probability of a car spawning on the vertical street
     */
    public static void setVProb(double Vprob) {
        VProb = Vprob;
    }

    /**
     *
     * @return Probability of a car spawning on the vertical street
     */
    public static double getVProb() {
        return VProb;
    }

    /**
     *
     * @param c The car to add to the simulation model
     */
    public static void addCar(Car c) {
        CarList.add(c);
    }

    /**
     *
     * @param c The car to remove from the simulation model
     */
    public static void removeCar(Car c) {
        CarList.remove(c);
    }

    /**
     *
     * @return the list of cars currently kept by the simulation model
     */
    public static ArrayList<Car> getCarList() {
        return CarList;
    }

    /**
     * Checks the cars for if they are still referenced and on road
     */
    public static void CheckCars() {
        ArrayList<Car> TempCars = new ArrayList<Car>();
        for (Car c : CarList) {
            if (c.checkOnRoad() == true) {
                TempCars.add(c);
            }
        }
        CarList = TempCars;
    }
}
