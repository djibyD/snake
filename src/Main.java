import model.GameZone;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 28/12/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello snake !");
        JFrame window = new JFrame("Snake");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        GameZone gameZone = new GameZone(20, 20, 100, 100, Color.RED);

        window.setContentPane(panel);
        window.setVisible(true);
    }
}
