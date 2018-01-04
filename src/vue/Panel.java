package vue;

import model.GameZone;
import model.Obstacle;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class Panel extends JPanel{

    private GameZone gameZone;
    private Obstacle obstacle;

    public Panel() {
        this.gameZone = new GameZone();
        this.obstacle = new Obstacle();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        this.gameZone.setBorderColour(Color.RED);
        this.gameZone.drawZone(graphics2D);
        this.obstacle.setShape(new Rectangle(60, 100, 10, 10));
        this.obstacle.draw(graphics2D);
    }
}
