package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by djiby on 30/12/17.
 */
public class Snake {

    private List<Part> body = new ArrayList<Part>();
    private Direction direction;
    private double speed;
    private State state;


    public Snake() {
        Part p1 = new Part(); p1.setShape(new Rectangle(250, 150, 10, 10));
        Part p2 = new Part(); p2.setShape(new Rectangle(250, 160, 10, 10));
        Part p3 = new Part(); p3.setShape(new Rectangle(250, 170, 10, 10));
        this.body.add(p1);
        this.body.add(p2);
        this.body.add(p3);
        this.direction = Direction.NORTH;
        this.state = State.STOPPED;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public  void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        for (Part part : body) {
            part.draw(graphics2D);
        }
    }

    public void move() {
        System.out.println("snake is moving !");
        this.state = State.MOVING;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (getState().equals(State.MOVING)){
                    System.out.println("Snake stepped forward !");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        thread.start();
    }

    public void stop() {
        System.out.println("Snake is stopped !");
        System.out.println("snake old state "+  state);
        this.state = State.STOPPED;
        System.out.println("snake new state "+ state);
    }
}
