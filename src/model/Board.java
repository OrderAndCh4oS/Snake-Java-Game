package model;

import java.awt.*;

/**
 * Created by sarcoma on 05/03/17.
 */
public class Board {
    private static final int BOARD_WIDTH = 80;
    private static final int BOARD_HEIGHT = 60;
    private char[][] boardData;
    private JRacer playerOne;

    public Board() {
        boardData = new char[BOARD_HEIGHT][BOARD_WIDTH];
        playerOne = new JRacer(Color.cyan);
        initBoardData();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (char[] aBoardData : boardData) {
            for (char anABoardData : aBoardData) {
                str.append(anABoardData);
            }
            str.append('\n');
        }
        return str.toString();
    }

    public char[][] initBoardData() {
        int x = playerOne.getX();
        int y = playerOne.getY();
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (x == j && y == i) {
                    boardData[i][j] = '1';
                } else {
                    boardData[i][j] = 'X';
                }
            }
        }
        return boardData;
    }

    public boolean isInBounds(int x, int y) {
        x = playerOne.getX() + x;
        y = playerOne.getY() + y;
        return x >= 0 && x < BOARD_WIDTH && y >= 0 && y < BOARD_HEIGHT;
    }

    public boolean isEmptySpace(int x, int y) {
        x = playerOne.getX() + x;
        y = playerOne.getY() + y;
        return boardData[y][x] == 'X';
    }

    public void updateBoardData() {
        boardData[playerOne.getY()][playerOne.getX()] = '1';
    }

    public JRacer getPlayerOne() {
        return playerOne;
    }

    public void movePlayerOne(int x, int y) {
        playerOne.setX(playerOne.getX() + x);
        playerOne.setY(playerOne.getY() + y);
        playerOne.addPointToTrail(new Point(playerOne.getX(), playerOne.getY()));
    }
}
