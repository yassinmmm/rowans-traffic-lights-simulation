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
    private static int index = 0;
    public int ID;

    Car() {
        ++index;
        this.ID = index;
    }
    @Override
    public String toString() {
        return "c";
    }
}
