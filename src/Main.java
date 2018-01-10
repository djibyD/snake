import vue.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 28/12/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello snake !");
        JFrame window = new JFrame("Snake");
        window.setExtendedState(Frame.MAXIMIZED_BOTH);
        System.out.println("Width : " + window.getBounds());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        window.setContentPane(panel);
        window.setVisible(true);
    }
}
