package view;

import controller.Controller;
import controls.KeyPressed;
import model.Board;

import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by sarcoma on 05/03/17.
 */
public class GamePanel extends BasePanel implements KeyListener {
    private boolean isGameOver = false;
    private int score = 0;
    private int timerDelay;
    private Timer timer;
    private KeyPressed keyPressed = KeyPressed.NONE;
    private Board board = new Board();

    public GamePanel(Controller controller) {
        super(controller);
        initialise();
        startTimer();
        startGame();
    }

    private void startTimer() {
        timerDelay = 1000/30;
        timer = new Timer(timerDelay, gameTimer);
        timer.start();
    }

    protected void initialise() {
        this.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setVisible(true);
        setBackground(new Color(255, 215, 0));
        addKeyListener(this);
    }

    public void startGame() {
        this.keyPressed = KeyPressed.RIGHT;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Point position : board.getPlayerOne().getTrail()) {
            graphics.setColor(board.getPlayerOne().getColour());
            graphics.fillRect(position.x * 10, position.y * 10, 10, 10);
            graphics.drawRect(position.x * 10, position.y * 10, 10, 10);
        }
    }

    private boolean isValidMove(int x, int y) {
        return board.isInBounds(x, y) && board.isEmptySpace(x, y);
    }

    public void redraw() {
        if (!isGameOver) {
            switch (keyPressed) {
                case UP:
                    movePlayer(0, -1);
                    break;
                case DOWN:
                    movePlayer(0, 1);
                    break;
                case LEFT:
                    movePlayer(-1, 0);
                    break;
                case RIGHT:
                    movePlayer(1, 0);
                    break;
                case NONE:
                    break;
            }
            repaint();
        }
    }

    private void movePlayer(int x, int y) {
        if (isValidMove(x, y)) {
            board.movePlayerOne(x, y);
            board.updateBoardData();
            score++;
        } else {
            isGameOver = true;
            controller.setCurrentPanel(new GameOverPanel(controller, score));
        }
    }

    ActionListener gameTimer = actionEvent -> redraw();

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 38:
                keyPressed = KeyPressed.UP;
                break;
            case 40:
                keyPressed = KeyPressed.DOWN;
                break;
            case 37:
                keyPressed = KeyPressed.LEFT;
                break;
            case 39:
                keyPressed = KeyPressed.RIGHT;
                break;
            default:
                keyPressed = KeyPressed.NONE;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
