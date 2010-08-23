/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
               Menu.Menu();
            } catch (NumberFormatException nfe) {
                System.out.println("    Please enter a valid digit!");
            }
        }
    }
}
