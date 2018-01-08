package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by djiby on 30/12/17.
 */
public class Snake {

    private List<Part> body = new ArrayList<Part>();

    public Snake() {
        Part p1 = new Part(); p1.setShape(new Rectangle(250, 150, 10, 10));
        Part p2 = new Part(); p2.setShape(new Rectangle(250, 160, 10, 10));
        Part p3 = new Part(); p3.setShape(new Rectangle(250, 170, 10, 10));
        this.body.add(p1);
        this.body.add(p2);
        this.body.add(p3);
    }
    
    public  void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        for (Part part : body) {
            part.draw(graphics2D);
        }
    }
}
