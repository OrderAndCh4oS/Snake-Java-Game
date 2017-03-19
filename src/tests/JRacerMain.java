package tests;

import model.Board;

/**
 * Created by sarcoma on 05/03/17.
 */
public class JRacerMain {
    private static Board board;
    public static void main(String[] args) {
        board = new Board();
        System.out.print(board);
    }
}
