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

    private String hGap() {
        String gap = "";
        for (int i = 0; i < Menu.getH_street(); i++) {
            gap += "\n";
        }
        return gap;
    }

    private String vGap() {
        String gap = "";
        for (int i = 0; i < Menu.getV_street(); i++) {
            gap += "   ";
        }
        return gap;
    }

    public void DrawRoad() {

        //char[][] RoadArr = new char[hLanes][vLanes];
        final String fill = "                    ";
        final String border = "-------------------";
        final int rows = 10;

        String hGap = hGap();
        String vGap = vGap();

        for (int i = 0; i < rows; i++) {
            System.out.println(fill + '|' + vGap + '|' + fill);
        }

        System.out.println(border + '-' + vGap + "  " + border);
        System.out.print(hGap);
        System.out.println(border + '-' + vGap + "  " + border);
        
        for (int x = 0; x < rows; x++) {
            System.out.println(fill + '|' + vGap + '|' + fill);
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
    }
}
