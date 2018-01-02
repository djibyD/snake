package model.vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by djiby on 02/01/18.
 */
public class Panel extends JPanel{

    private Shape shape;


    public Panel(Shape shape) {
        this.shape = shape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
