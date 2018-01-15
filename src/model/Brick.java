package model;

import java.awt.*;

/**
 * Created by djiby on 31/12/17.
 */
public abstract class Brick {

    private Shape shape;
    private Point position;
    private Color color;

    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) { this.color = color; }

    public Point getPosition() { return position; }

    public void setPosition(Point position) {
        this.position = position;
    }

    public abstract void draw(Graphics2D graphics2D);

}
