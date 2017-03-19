package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarcoma on 19/03/17.
 */
public abstract class BasePanel extends JPanel {
    protected static final int DEFAULT_WIDTH = 800;
    protected static final int DEFAULT_HEIGHT = 600;
    protected Controller controller;

    public BasePanel(Controller controller) {
        super();
        this.controller = controller;
    }

    protected void setupLabel(String s, String layout, int fontSize, Color colour) {
        JLabel label = new JLabel(s, SwingConstants.CENTER);
        label.setFont(new Font("Verdana", 1, fontSize));
        label.setForeground(colour);
        add(label, layout);
    }

    protected abstract void initialise();
}
