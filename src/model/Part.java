package model;

import java.awt.*;

/**
 * Created by djiby on 05/01/18.
 */
public class Part extends Brick {

    public Part() {
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.fill(this.getShape());
    }
}
