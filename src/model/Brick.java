package model;

import java.awt.*;

/**
 * Created by djiby on 31/12/17.
 */
public abstract class Brick {

    private Point position;
    private Color color;

    public Point getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Brick(Point position, Color color) {
        this.position = position;
        this.color = color;

    }
}
