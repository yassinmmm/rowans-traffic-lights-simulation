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
    private static double HProb = 0.6;
    private static double VProb = 0.4;
    private static ArrayList<Car> CarList = new ArrayList<Car>();
    public static final int GRID_SIZE = 30;

    public static void setHorLanes(int Hnum) {
        HorLanes = Hnum;
        CheckCars();
    }

    public static int getHorLanes() {
        return HorLanes;
    }

    public static void setVertLanes(int Vnum) {
        VertLanes = Vnum;
        CheckCars();
    }

    public static int getVertLanes() {
        return VertLanes;
    }

    public static void setHProb(double Hprob) {
        HProb = Hprob;
    }

    public static double getHprob() {
        return HProb;
    }

    public static void setVProb(double Vprob) {
        VProb = Vprob;
    }

    public static double getVProb() {
        return VProb;
    }

    public static void addCar(Car c) {
        CarList.add(c);
    }

    public static void removeCar(Car c) {
        CarList.remove(c);
    }

    public static ArrayList<Car> getCarList() {
        return CarList;
    }

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
