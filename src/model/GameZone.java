package model;

import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class GameZone {

    private final int ABSCISSE = 200;
    private final int ORDONEE = 150;
    private final int WIDTH = 900;
    private final int HEIGHT = 500;
    private Color borderColour;

    public GameZone() {}

    public Color getBorderColour() {
        return borderColour;
    }

    public void setBorderColour(Color borderColour) {
        this.borderColour = borderColour;
    }

    public void drawZone(Graphics2D graphics2D){
        graphics2D.setColor(this.borderColour);
        graphics2D.drawRect(ABSCISSE, ORDONEE, WIDTH, HEIGHT);
    }
}