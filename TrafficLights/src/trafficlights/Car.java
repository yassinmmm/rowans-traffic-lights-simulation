/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/**
 *
 * @author Confucius
 */
public abstract class Car {

    protected int Gridrow;
    protected int Gridcol;
    protected int[] loc = new int[2];
    public String moving;

    protected abstract int[] loc();

    public abstract boolean checkOnRoad();

    public abstract void MoveForward();

    @Override
    public String toString() {
        return "c";
    }

    @Override
    public boolean equals(Object o) {
        return moving == (String) o;
    }
}
