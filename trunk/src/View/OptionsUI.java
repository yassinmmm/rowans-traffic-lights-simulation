/**
 *
 * @author Confucius
 */
package View;

import Controller.*;
import Model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class OptionsUI extends JFrame {

    private JSlider HLanes = new JSlider();
    private JLabel HLabel = new JLabel("Number of Horizontal Lanes - ");
    private JSlider VLanes = new JSlider();
    private JLabel VLabel = new JLabel("Number of Vertical Lanes - ");
    private JSlider HProb = new JSlider();
    private JLabel HProbLabel = new JLabel("Chance of cars entering the Horizontal Street - ");
    private JSlider VProb = new JSlider();
    private JLabel VProbLabel = new JLabel("Chance of cars entering the Vertical Street - ");
    private JSlider GridSz = new JSlider();
    private JLabel Grid = new JLabel("Size of the grid - ");
    private JButton Run = new JButton("Run");

    private Timer timer = new Timer();
    private TimerTask DrawGrid;

    private Simulator Sim;
    private boolean running = true;

//    class MyThread implements Runnable {
//
//        @Override
//        public void run() {
//            Sim.Simulate();
//        }
//    }
//    MyThread t = new MyThread();

    public OptionsUI() {
        Sim = new Simulator();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel MFrame = new JPanel();
        JPanel Options = new JPanel();

        Options.setLayout(new GridLayout(11, 1));
        MFrame.setLayout(new BorderLayout());

        HLanes.setMaximum(SimModel.MAX_HOR_LANES);
        HLanes.setMinimum(1);
        VLanes.setMaximum(SimModel.MAX_VER_LANES);
        VLanes.setMinimum(1);
        HProb.setMaximum(100);
        VProb.setMaximum(100);
        GridSz.setMaximum(SimModel.MAX_GRID_SZ);
        GridSz.setMinimum(SimModel.MIN_GRID_SZ);
        GridSz.setExtent(1);
        GridSz.setValue(800);

        // Binding slider event handlers to functions
        HLanes.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                HLanesStateChanged(e);
            }
        });
        VLanes.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                VLanesStateChanged(e);
            }
        });
        HProb.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                HProbStateChanged(e);
            }
        });
        VProb.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                VProbStateChanged(e);
            }
        });
        GridSz.addChangeListener(new javax.swing.event.ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                GridSzStateChanged(e);
            }
        });

        Run.addMouseListener(new javax.swing.event.MouseInputListener() {

            public void mouseClicked(MouseEvent e) {
                ToggleRun(e);
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
            }

            public void mouseMoved(MouseEvent e) {
            }
        });

        this.add(MFrame);

        MFrame.add(Options, BorderLayout.WEST);

        Options.add(HLabel);
        Options.add(HLanes);

        Options.add(VLabel);
        Options.add(VLanes);

        Options.add(HProbLabel);
        Options.add(HProb);

        Options.add(VProbLabel);
        Options.add(VProb);

        Options.add(Grid);
        Options.add(GridSz);

        Options.add(Run);

        pack();
    }

    // Slider Event Handlers
    private void HLanesStateChanged(javax.swing.event.ChangeEvent evt) {
        Sim.SetHLanes(HLanes);
    }

    private void VLanesStateChanged(javax.swing.event.ChangeEvent evt) {
        Sim.SetVLanes(VLanes);
    }

    private void HProbStateChanged(javax.swing.event.ChangeEvent evt) {
        Sim.SetHProb(HProb);
    }

    private void VProbStateChanged(javax.swing.event.ChangeEvent evt) {
        Sim.SetVProb(VProb);
    }

    private void GridSzStateChanged(javax.swing.event.ChangeEvent evt) {
        Sim.SetGridSz(GridSz);
    }

    private void ToggleRun(MouseEvent e) {
        if (Run.getText().equals("Run")) {
            Run.setText("Pause");
            running = true;
            while (true) {
                if (running) {
                    Sim.Simulate();
                }
                break;
            }
            return;
        }

        Run.setText("Run");
        running = false;
    }
}
