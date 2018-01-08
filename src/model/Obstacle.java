package model;

import java.awt.*;

/**
 * Created by djiby on 04/01/18.
 */
public class Obstacle extends Brick {

    public Obstacle() {
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(this.getColor());
        graphics2D.fill(this.getShape());
    }
}
