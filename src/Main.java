import model.GameZone;
import vue.Panel;

import javax.swing.*;

/**
 * Created by djiby on 28/12/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello snake !");
        JFrame window = new JFrame("Snake");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        //panel.setBackground(Color.red);
        window.setContentPane(panel);
        window.setVisible(true);
    }
}
