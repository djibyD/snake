package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class Panel extends JPanel{

    private Shape shape;
    //Center of every component

    public Panel() {
        System.out.println("Hello snake");
    }

    public void paintComponent(Graphics g) {
        this.setBackground(Color.red);
        System.out.println("Inside panel");
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;

        graphics2D.setColor(Color.blue);
        graphics2D.fillRect(20, 20, 100, 100);
        System.out.println("Hello");
    }
}
