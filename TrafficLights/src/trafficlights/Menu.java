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

    private static Scanner scanner = new Scanner(System.in);
    private static String input;

    private static final byte MIN_VERT_LANES = 1;
    private static final byte MAX_VERT_LANES = 4;
    private static final byte MIN_HOR_LANES = 1;
    private static final byte MAX_HOR__LANES = 3;
    
    private static final byte SET_HOR_LANES = 1;
    private static final byte SET_VERT_LANES = 2;
    private static final byte SET_HOR_PROB = 3;
    private static final byte SET_VERT_PROB = 4;
    private static final byte RUN_ONCE = 5;
    private static final byte RUN_N_TIMES = 6;


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
                    System.out.println("    Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < MIN_VERT_LANES || number > MAX_VERT_LANES) {
                System.out.println("    There must be more than 1 lane and less than 4!");
            } else {
                break set_v;
            }
        }
        SimModel.setVertLanes(number);
        System.out.println("Simulation now has " + SimModel.getVertLanes() + " vertical lanes.");
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
                    System.out.println("    Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < MIN_HOR_LANES || number > MAX_HOR__LANES) {
                System.out.println("    There must be more than 1 lane and less than 3!");
            } else {
                break set_h;
            }
        }
        SimModel.setHorLanes(number);
        System.out.println("Simulation now has " + SimModel.getHorLanes() + " horizontal lanes.");
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
                    System.out.println("    Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 0 || number > 1) {
                System.out.println("    Probability must be between 0.0 & 1.0!");
            } else {
                break set_h;
            }
        }
        SimModel.setHProb(number);
        System.out.println("Cars now have a " + SimModel.getHprob() + " chance of entering the horizontal lanes");
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
                    System.out.println("    Please enter a digit!");
                    continue check_valid;
                }
                break check_valid;
            }

            if (number < 0 || number > 1) {
                System.out.println("    Probability must be between 0.0 & 1.0!");
            } else {
                break set_v;
            }
        }
        SimModel.setVProb(number);
        System.out.println("Cars now have a " + SimModel.getVProb() + " chance of entering the vertical lanes");
    }

    /**
     * @param args the command line arguments
     */
    public static void Menu() {
        input = "";
        int number;
        System.out.print("\n=== MENU ====\n"
                + "1. Set Number of horizontal lanes (H-street) [min 1, max 3]\n"
                + "2. Set Number of vertical lanes (V-street) [min 1, max 4]\n"
                + "3. Set Probability of a car entering H-street [min 0, max 1]\n"
                + "4. Set Probability of a car entering V-street [min 0, max 1]\n"
                + "5. Run one simulation cycle\n"
                + "6. Set and run number of simulation cycles [min 1, max 10]\n\n"
                + "Enter your choice > ");

        input = scanner.next();
        number = Integer.parseInt(input);

        switch (number) {
            case SET_HOR_LANES: //1. Set Number of horizontal lanes
                setH_street();
                break;

            case SET_VERT_LANES: //2. Set Number of vertical lanes
                setV_street();
                break;

            case SET_HOR_PROB: //3. Set Probability of a car entering H-street
                setH_prob();
                break;

            case SET_VERT_PROB: //4. Set Probability of a car entering V-street
                setV_prob();
                break;

            case RUN_ONCE: //5. Run one simulation cycle
                Simulator.Simulate(1);
                break;

            case RUN_N_TIMES: //6. Set and run number of simulation cycles
                while (true) {
                    int rTimes = 0;
                    System.out.println("\nHow many simulation cycles?");
                    System.out.print("> ");
                    input = scanner.next();
                    try {
                        rTimes = Integer.parseInt(input);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error! Invalid number.");
                        continue;
                    }
                    Simulator.Simulate(rTimes);
                    break;
                }
                break;
                
            default:
                System.out.println("    Invalid Selection");
        }
    }
}
