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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lights lights = new Lights();

        while (true) {
            String input = null;
            int number = -123456789;
            double prob;

            System.out.print("=== MENU ====\n"
                    + "1. Set Number of horizontal lanes (H-street) [min 1, max 3]\n"
                    + "2. Set Number of vertical lanes (V-street) [min 1, max 4]\n"
                    + "3. Set Probability of a car entering H-street [min 0, max 1]\n"
                    + "4. Set Probability of a car entering V-street [min 0, max 1]\n"
                    + "5. Run one simulation cycle\n"
                    + "6. Set and run number of simulation cycles [min 1, max 10]\n\n"
                    + "Enter your choice> ");

            //If user enters ans value as input then program
            //produces errors
            while (number == -123456789) {
                input = scanner.next();
                try {
                    number = Integer.parseInt(input);
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a valid digit!");
                    System.out.print("Enter your choice> ");
                }
            }


            switch (number) {
                case 1:
                    //If user enters H_number value as input then program
                    //produces errors
                    number = -123456789;

                    System.out.print("Number of horizontal lanes [min 1, max 3]: ");

                    while (true) {
                        number = -123456789;
                        while (number == -123456789) {
                            input = scanner.next();
                            try {
                                number = Integer.parseInt(input);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Number of horizontal lanes [min 1, max 3]: ");
                            }
                        }

                        if (number < 1 || number > 3) {
                            System.out.println("There must be more than 1 lane and less than 3!");
                            System.out.print("Number of horizontal lanes [min 1, max 3]: ");
                        } else {
                            break;
                        }
                    }

                    h_street = number;
                    System.out.println("The simulation now has " + h_street + " horizontal lanes.\n");
                    break;

                case 2:
                    //If user enters V_number value as input then program
                    //produces errors
                    number = -123456789;

                    System.out.print("Number of vertical lanes [min 1, max 4]: ");

                    while (true) {
                        number = -123456789;
                        while (number == -123456789) {
                            input = scanner.next();
                            try {
                                number = Integer.parseInt(input);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Number of vertical lanes [min 1, max 4]: ");
                            }
                        }

                        if (number < 1 || number > 4) {
                            System.out.println("There must be more than 1 lane and less than 4!");
                            System.out.print("Number of vertical lanes [min 1, max 4]: ");
                        } else {
                            break;
                        }
                    }

                    v_street = number;
                    System.out.println("The simulation now has " + v_street + " vertical lanes.\n");
                    break;

                case 3:
                    //If user enters prob value as input then program
                    //produces errors
                    prob = -0.123456789;

                    System.out.print("Probability of cars entering horizontal lane [min 0.0, max 1.0]: ");

                    while (true) {
                        prob = -0.123456789;
                        while (prob == -0.123456789) {
                            input = scanner.next();
                            try {
                                prob = Double.parseDouble(input);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Probability of cars entering horizontal lane [min 0.0, max 1.0]: ");
                            }
                        }

                        if (prob < 0 || prob > 1) {
                            System.out.println("Probability must be between 0.0 & 1.0!");
                            System.out.print("Probability of cars entering horizontal lane [min 0.0, max 1.0]: ");
                        } else {
                            break;
                        }
                    }

                    v_prob = prob;
                    System.out.println("Cars now have a " + v_prob + " chance of entering the horizontal lanes\n");
                    break;

                case 4:
                    //If user enters prob value as input then program
                    //produces errors
                    prob = -0.123456789;

                    System.out.print("Probability of cars entering vertical lane [min 0.0, max 1.0]: ");

                    while (true) {
                        prob = -0.123456789;
                        while (prob == -0.123456789) {
                            input = scanner.next();
                            try {
                                prob = Double.parseDouble(input);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Probability of cars entering vertical lane [min 0.0, max 1.0]: ");
                            }
                        }

                        if (prob < 0 || prob > 1) {
                            System.out.println("Probability must be between 0.0 & 1.0!");
                            System.out.print("Probability of cars entering vertical lane [min 0.0, max 1.0]: ");
                        } else {
                            break;
                        }
                    }

                    v_prob = prob;
                    System.out.println("Cars now have a " + v_prob + " chance of entering the vertical lanes\n");
                    break;

                case 5:
                    lights.DrawRoad(h_street, v_street);
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                default:
                    System.out.println("Invalid Selection");
            }
        }
    }
}
