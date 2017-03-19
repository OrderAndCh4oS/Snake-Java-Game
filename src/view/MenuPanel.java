package view;

import controller.Controller;
import listeners.StartGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarcoma on 18/03/17.
 */
public class MenuPanel extends BasePanel {

    public MenuPanel(Controller controller) {
        super(controller);
        initialise();
    }

    protected void initialise() {
        setupPanel();
        setupLabel("SNAKE", BorderLayout.NORTH, 150, Color.CYAN);
        setupStartButton();
    }

    private void setupStartButton() {
        JButton startButton = new JButton("START GAME");
        startButton.setBackground(Color.CYAN);
        startButton.setForeground(Color.BLACK);
        startButton.addActionListener(new StartGame(controller));
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        this.add(startButton, BorderLayout.PAGE_END);
    }

    private void setupPanel() {
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setVisible(true);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
    }
}
