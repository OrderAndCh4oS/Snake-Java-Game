package listeners;

import controller.Controller;
import view.GamePanel;
import view.MenuPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sarcoma on 18/03/17.
 */
public class ResetGame implements ActionListener {

    private Controller controller;

    public ResetGame(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        controller.setCurrentPanel(new MenuPanel(controller));
    }
}
