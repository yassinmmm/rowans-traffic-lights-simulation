/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JSlider;

/**
 *
 * @author Confucius
 */
public class Simulator {

    private SimModel TrafficSim;
    private Display SimDisplay;
    private BufferedImage[] imgArr;

    public Simulator() {
        TrafficSim = new SimModel();
        imgArr = new BufferedImage[1];
        UpdateImages();
        SimDisplay = new Display(imgArr[0]);
    }

    public void Simulate() {
        UpdateImages();
        SimDisplay.updateComponents(imgArr);
    }

    public void UpdateImages() {
        int sz = TrafficSim.getGridSz();
        BufferedImage bg = new BufferedImage(sz,
                sz,
                BufferedImage.TYPE_3BYTE_BGR);
        bg.createGraphics();
        Graphics2D g = (Graphics2D) bg.getGraphics();

        g.setColor(Color.green);
        g.fillRect(0, 0, sz, sz);
        g.setColor(Color.BLACK);
        g.fillRect(sz / 2 - TrafficSim.LANE_WIDTH, 0, TrafficSim.getVLanes() * TrafficSim.LANE_WIDTH, sz);  // Vertical   Road
        g.fillRect(0, sz / 2  - TrafficSim.LANE_WIDTH, sz, TrafficSim.getHLanes() * TrafficSim.LANE_WIDTH);  // Horizontal Road

        this.imgArr[0] = bg;
    }

    public void SetHLanes(JSlider HLanes) {
        TrafficSim.setHLanes(HLanes.getValue());
    }

    public void SetVLanes(JSlider VLanes) {
        TrafficSim.setVLanes(VLanes.getValue());
    }

    public void SetHProb(JSlider HProb) {
        TrafficSim.setHProb(HProb.getValue());
    }

    public void SetVProb(JSlider VProb) {
        TrafficSim.setVProb(VProb.getValue());
    }

    public void SetGridSz(JSlider GridSz) {
        TrafficSim.setGridSz(GridSz.getValue());
    }
}

