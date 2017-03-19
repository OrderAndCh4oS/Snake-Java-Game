package listeners;

import controller.Controller;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sarcoma on 18/03/17.
 */
public class StartGame implements ActionListener {

    private Controller controller;

    public StartGame(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        controller.setCurrentPanel(new GamePanel(controller));
    }
}
