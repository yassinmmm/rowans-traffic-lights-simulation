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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans;
        int h_street = 1;
        int v_street = 1;

        while (true) {
            System.out.print("=== MENU ====\n"
                    + "1. Set Number of horizontal lanes (H-street) [min 1, max 3]\n"
                    + "2. Set Number of vertical lanes (V-street) [min 1, max 4]\n"
                    + "3. Set Probability of a car entering H-street [min 0, max 1]\n"
                    + "4. Set Probability of a car entering V-street [min 0, max 1]\n"
                    + "5. Run one simulation cycle\n"
                    + "6. Set and run number of simulation cycles [min 1, max 10]\n\n"
                    + "Enter your choice> ");
            ans = scanner.nextInt();
            ///System.out.println(ans);
            ///v_street = System.in.read();
            //System.out.println(v_street);
            switch (ans) {
                case 1:
                    int H_number;
                    String H_val = "";

                    System.out.print("Number of horizontal lanes [min 1, max 3]: ");

                    while (true) {
                        H_number = 0;
                        while (H_number == 0) {
                            H_val = scanner.next();
                            try {
                                H_number = Integer.parseInt(H_val);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Number of horizontal lanes [min 1, max 3]: ");
                            }
                        }

                        if (H_number < 1 || H_number > 3) {
                            System.out.println("There must be more than 1 lane and less than 3!");
                            System.out.print("Number of horizontal lanes [min 1, max 3]: ");
                        } else {
                            break;
                        }
                    }

                    h_street = H_number;
                    System.out.println("The simulation now has " + h_street + " horizontal lanes.");

                    break;
                case 2:
                    int V_number;
                    String V_val = "";

                    System.out.print("Number of horizontal lanes [min 1, max 4]: ");

                    while (true) {
                        V_number = 0;
                        while (V_number == 0) {
                            V_val = scanner.next();
                            try {
                                V_number = Integer.parseInt(V_val);
                            } catch (NumberFormatException nfe) {
                                System.out.println("Please enter a digit!");
                                System.out.print("Number of horizontal lanes [min 1, max 4]: ");
                            }
                        }

                        if (V_number < 1 || V_number > 4) {
                            System.out.println("There must be more than 1 lane and less than 4!");
                            System.out.print("Number of horizontal lanes [min 1, max 4]: ");
                        } else {
                            break;
                        }
                    }

                    v_street = V_number;
                    System.out.println("The simulation now has " + v_street + " vertical lanes.");

                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
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
