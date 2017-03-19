package controller;

import view.MenuPanel;

import javax.swing.*;

/**
 * Created by sarcoma on 05/03/17.
 */
@SuppressWarnings("serial")
public class Controller extends JFrame {
    private JPanel currentPanel;

    public Controller() {
        super("Tron Racer");
        currentPanel = new MenuPanel(this);
        start();
    }

    public void start() {
        setVisible(true);
        addBuildGUI();
    }

    private void addBuildGUI() {
        add(currentPanel);
        pack();
    }

    public void setCurrentPanel(JPanel newPanel) {
        setContentPane(newPanel);
        invalidate();
        validate();
        currentPanel = newPanel;
    }
}
