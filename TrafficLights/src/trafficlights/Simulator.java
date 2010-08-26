/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author jc223892
 */
public class Simulator {

    private static int[] ExistingIDs = new int[999];
    private static int IDindex;
    private static int Rlength = 0;

    private static String hGap() {
        String gap = "";
        for (int i = 0; i < Menu.getH_street(); i++) {
            gap += "\n";
        }
        return gap;
    }

    private static String vGap() {
        String gap = "";
        for (int i = 0; i < Menu.getV_street(); i++) {
            gap += " ";
            Rlength++;
        }
        return gap;
    }

    public static void MakeCar() {
        Car newCar = new Car();
        ExistingIDs[IDindex] = newCar.ID;
        ++IDindex;
    }

    public static void DrawRoad() {
        //Making setup
        String vGap = vGap();
        String hGap = hGap();

        Car[] VRoadArr = new Car[Menu.getV_street()];
        Car[] HRoadArr = new Car[2 * (20 + Rlength)];

        Lights trafficLights = new Lights();

        final String fill = "                    ";
        final String border = "-------------------";
        final int rows = 10;

        for (int i = 0; i < rows; i++) {
            System.out.println(fill + '|' + vGap + '|' + fill);
        }

        System.out.println(border + '-' + vGap + "  " + border);

        for (int x = 0; x < Menu.getV_street(); x++) {
            for (int p : ExistingIDs) {
                if (VRoadArr[x].ID == ExistingIDs[p]) {
                    for (int z = 0; z < HRoadArr.length; z++) {
                        for (int l : ExistingIDs) {
                            if (HRoadArr[z].ID == ExistingIDs[l]) {
                                System.out.println(ExistingIDs[l]);
                            } else if (!(z == HRoadArr.length - 1)) {
                                System.out.print(" ");
                            }

                        }
                    }
                } else if (!(x == Menu.getV_street() - 1)) {
                    System.out.println("");
                }
            }
        }

//System.out.print(hGap);
        System.out.println(border + '-' + vGap + "  " + border);

        for (int x = 0; x
                < rows; x++) {
            System.out.println(fill + '|' + vGap + '|' + fill);

        }
    }

    public static void Simulate() {
        Random rand = new Random();
      
        Double D = Menu.getH_prob() * 100;
        int R = rand.nextInt(100);

        if (R < D) {
            System.out.println("Make car");
            MakeCar();
        }
    }

    /*
    for (int i = 0; i < 26; i++) {
    if (i < 13 || i > (14 + hLanes)) {
    //Prints vertical right boundary
    System.out.print("                      |");
    //Creates vertical lanes then adds the right boundary
    for (int x = 0; x < vLanes; x++) {
    System.out.print(" ");
    }

    System.out.print("|                      \n");
    } else {
    //Draws the horizontal boundary's
    if (i == 13 || i == (14 + hLanes)) {
    System.out.print("---------------------- ");

    for (int x = 0; x < vLanes; x++) {
    System.out.print(" ");
    }

    System.out.println(" ---------------------");
    } else {
    //Car positioning here
    }
    }
    }
     *
     */
    /*
    Random rand = new Random();
    Timer time = new Timer();

    public void Run() {
    for (int i = 0; i < 10; ++i) {

    try {
    time.wait(1000);
    } catch (InterruptedException ex) {
    Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    }
     **/
}
