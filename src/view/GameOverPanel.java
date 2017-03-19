package view;

import controller.Controller;
import listeners.ResetGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sarcoma on 19/03/17.
 */
public class GameOverPanel extends BasePanel {

    private int score = 0;

    public GameOverPanel(Controller controller, int score) {
        super(controller);
        this.score = score;
        initialise();
    }

    @Override
    protected void initialise() {
        setupPanel();
        setupLabel("GAME OVER", BorderLayout.NORTH, 119, Color.BLACK);
        setupLabel("Score: " + String.valueOf(this.score), BorderLayout.CENTER, 50, Color.BLACK);
        setupOkButton();
    }

    private void setupPanel() {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setVisible(true);
        setBackground(Color.RED);
        setLayout(new BorderLayout());
    }

    private void setupOkButton() {
        JButton okButton = new JButton("OK");
        okButton.setBackground(Color.BLACK);
        okButton.setForeground(Color.RED);
        okButton.addActionListener(new ResetGame(controller));
        okButton.setFont(new Font("Verdana", Font.PLAIN, 40));
        this.add(okButton, BorderLayout.PAGE_END);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
