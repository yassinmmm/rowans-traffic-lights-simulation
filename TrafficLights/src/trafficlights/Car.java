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

    /**
     * The Grid row the car is in
     */
    protected int Gridrow;
    /**
     * The Grid column the car is in
     */
    protected int Gridcol;
    /**
     * The location of where the car is
     */
    protected int[] loc = new int[2];
    /**
     * If the car is moving or not
     */
    public String moving;
     /**
     *
     * @return the location of where the car is
     */
    protected abstract int[] loc();
    /**
     * Checks to see if the car is out of bounds, and removes it
     */
    public abstract boolean checkOnRoad();

    /**
     * Moves the car one space if possible
     */
    public abstract void Move();

    @Override
    public String toString() {
        return "c";
    }

    @Override
    public boolean equals(Object o) {
        return moving == (String) o;
    }
}
