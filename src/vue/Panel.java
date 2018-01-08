package vue;

import model.GameZone;
import model.Obstacle;
import model.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class Panel extends JPanel{

    private GameZone gameZone;
    private Obstacle obstacle;
    private Snake snake;

    public Panel() {
        this.gameZone = new GameZone();
        this.obstacle = new Obstacle();
        this.obstacle.setShape(new Rectangle(60, 100, 10, 10));
        this.snake = new Snake();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        this.gameZone.setBorderColour(Color.RED);
        this.gameZone.drawZone(graphics2D);
        this.obstacle.draw(graphics2D);
        this.snake.draw(graphics2D);
    }
}
