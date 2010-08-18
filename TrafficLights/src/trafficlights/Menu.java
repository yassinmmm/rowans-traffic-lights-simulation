/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

import java.util.Scanner;

/**
 *
 * @author Confucius
 */
public class Menu {

    private static int h_street = 1;
    private static double h_prob;
    private static int v_street = 1;
    private static double v_prob;
    private static Scanner scanner = new Scanner(System.in);
    private static String input;
    static Lights lights = new Lights();

    private static void setV_street() {
        input = "";
        int number = 0;

        set_v:
        while (true) {
            check_valid:
            while (true) {
                System.out.print("\nNumber of vertical lanes [min 1, max 4]: ");
                input = scanner.next();
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 1 || number > 4) {
                System.out.println("There must be more than 1 lane and less than 4!");
            } else {
                break set_v;
            }
        }
        v_street = number;
        System.out.println("Simulation now has " + v_street + " vertical lanes.\n");
    }

    public static int getV_street() {
        return v_street;
    }

    private static void setH_street() {
        input = "";
        int number = 0;

        set_h:
        while (true) {
            check_valid:
            while (true) {
                System.out.print("\nNumber of horizontal lanes [min 1, max 3]: ");
                input = scanner.next();
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 1 || number > 3) {
                System.out.println("There must be more than 1 lane and less than 3!");
            } else {
                break set_h;
            }
        }
        h_street = number;
        System.out.println("Simulation now has " + h_street + " horizontal lanes.\n");
    }

    public static int getH_street() {
        return h_street;
    }

    private static void setH_prob() {
        input = "";
        double number = 0;

        set_h:
        while (true) {
            check_valid:
            while (true) {
                System.out.print("\nProbability of cars entering horizontal lane [min 0.0, max 1.0]: ");
                input = scanner.next();
                try {
                    number = Double.parseDouble(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 0 || number > 1) {
                System.out.println("Probability must be between 0.0 & 1.0!");
            } else {
                break set_h;
            }
        }
        h_prob = number;
        System.out.println("Cars now have a " + h_prob + " chance of entering the horizontal lanes\n");
    }

    public static double getH_prob() {
        return h_prob;
    }

    private static void setV_prob() {
        input = "";
        double number = 0;

        set_v:
        while (true) {
            check_valid:
            while (true) {
                System.out.print("\nProbability of cars entering vertical lane [min 0.0, max 1.0]: ");
                input = scanner.next();
                try {
                    number = Double.parseDouble(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 0 || number > 1) {
                System.out.println("Probability must be between 0.0 & 1.0!");
            } else {
                break set_v;
            }
        }
        v_prob = number;
        System.out.println("Cars now have a " + v_prob + " chance of entering the vertical lanes\n");
    }

    public static double getV_prob() {
        return v_prob;
    }

    /**
     * @param args the command line arguments
     */
    public static void Menu() {
        input = "";
        int number;
        
        System.out.print("=== MENU ====\n"
                + "1. Set Number of horizontal lanes (H-street) [min 1, max 3]\n"
                + "2. Set Number of vertical lanes (V-street) [min 1, max 4]\n"
                + "3. Set Probability of a car entering H-street [min 0, max 1]\n"
                + "4. Set Probability of a car entering V-street [min 0, max 1]\n"
                + "5. Run one simulation cycle\n"
                + "6. Set and run number of simulation cycles [min 1, max 10]\n\n"
                + "Enter your choice> ");

        input = scanner.next();
        number = Integer.parseInt(input);

        switch (number) {
            case 1:
                setH_street();
                break;

            case 2:
                setV_street();
                break;

            case 3:
                setH_prob();
                break;

            case 4:
                setV_prob();
                break;

            case 5:
                lights.DrawRoad();
                break;

            case 6:
                System.out.println("Six");
                break;
            default:
                System.out.println("Invalid Selection");
        }
    }
}
