import controller.Controller;

/**
 * Created by sarcoma on 05/03/17.
 */
public class JRacerMain {
    private static Controller boardView;
    public static void main(String[] args) {
        boardView = new Controller();
        boardView.start();
    }
}
