/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public class Lights {

    public void DrawRoad(int hLanes, int vLanes) {
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
    }
}
