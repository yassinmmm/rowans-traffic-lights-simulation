/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;

/**
 *
 * @author Confucius
 */
public class SimModel {

    public static final int MAX_GRID_SZ = 1000;
     public static final int MIN_GRID_SZ = 300;
    public static final int MAX_HOR_LANES = 3;
    public static final int MAX_VER_LANES = 3;

    public int LANE_WIDTH;
    
    private int HLanes;
    private int VLanes;
    private int HProb;
    private int VProb;
    private int GridSz;

    public SimModel() {
        this.HLanes = 3;
        this.VLanes = 3;
        this.HProb = 50;
        this.VProb = 50;
        this.GridSz = 800;
        LANE_WIDTH = GridSz / 20;
    }

    public int getHLanes() {
        return HLanes;
    }

    public int getHProb() {
        return HProb;
    }

    public int getVLanes() {
        return VLanes;
    }

    public int getVProb() {
        return VProb;
    }

    public int getGridSz() {
        return GridSz;
    }

    public void setHLanes(int HLanes) {
        this.HLanes = HLanes;
    }

    public void setHProb(int HProb) {
        this.HProb = HProb;
    }

    public void setVLanes(int VLanes) {
        this.VLanes = VLanes;
    }

    public void setVProb(int VProb) {
        this.VProb = VProb;
    }

    public void setGridSz(int Gridsz) {
        this.GridSz = Gridsz;
        LANE_WIDTH = GridSz / 20;
    }
}
