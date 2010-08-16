/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trafficlights;

/**
 *
 * @author jc223892
 */
public class Car {
    private double H_prob;
    private double V_prob;

    public Car(double hprob, double vprob){
        this.H_prob = hprob;
        this.V_prob = vprob;
    }

    @Override
    public String toString() {
        return "c";
    }
}
