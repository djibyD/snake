package model;

import javax.swing.*;
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
        Part p1 = new Part();
        p1.setPosition(new Point(250, 350));
        p1.setShape(new Rectangle(250, 350, 10, 10));
        Part p2 = new Part();
        p2.setPosition(new Point(250, 361));
        p2.setShape(new Rectangle(250, 361, 10, 10));
        Part p3 = new Part();
        p3.setPosition(new Point(250, 372));
        p3.setShape(new Rectangle(250, 372, 10, 10));
        this.body.add(p3);
        this.body.add(p2);
        this.body.add(p1);
        this.state = State.STOPPED;
        this.direction = Direction.NORTH;
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

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.BLUE);
        for (Part part : body) {
            part.draw(graphics2D);
        }
    }

    public void move(JPanel panel) {
        System.out.println("snake is moving !");
        state = State.MOVING;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state.equals(State.MOVING)){
                    System.out.println("Snake stepped forward !");
                    forward();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /*snakeString();*/
                    panel.repaint();

                }
            }
        });
        thread.start();
    }

    public void stop() {
        System.out.println("Snake is stopped !");
        state = State.STOPPED;
        System.out.println("snake new state "+ state);
    }

    public Point getHeadPosition() {
        return body.get(0).getPosition();
    }

    public void forward() {
        //Only moving north in the case
        int snakeLength = body.size();
        Part newHead = new Part();
        Point headPosition = getHeadPosition();
        body.remove(snakeLength-1);
        int x = headPosition.x;
        int y = headPosition.y;

        switch (direction){
            case EST:
                newHead.setPosition(new Point(x+11, y));
                newHead.setShape(new Rectangle(x+11, y, 10, 10));
                body.add(0, newHead);
                break;
            case WEST:
                newHead.setPosition(new Point(x-11, y));
                newHead.setShape(new Rectangle(x-11, y, 10, 10));
                body.add(0, newHead);
                break;
            case NORTH:
                newHead.setPosition(new Point(x, y-11));
                newHead.setShape(new Rectangle(x, y-11, 10, 10));
                body.add(0, newHead);
                break;
            case SOUTH:
                newHead.setPosition(new Point(x, y+11));
                newHead.setShape(new Rectangle(x, y+11, 10, 10));
                body.add(0, newHead);
                break;
        }


    }

    public void left() {
        if (state == State.MOVING) {
            switch (direction){
                case NORTH: setDirection(Direction.WEST); break;
                case SOUTH: setDirection(Direction.EST); break;
                case WEST: setDirection(Direction.SOUTH); break;
                case EST: setDirection(Direction.NORTH); break;
            }
        }
    }

    public void right() {
        if(state == State.MOVING){
            switch (direction){
                case NORTH: setDirection(Direction.EST); break;
                case SOUTH: setDirection(Direction.WEST); break;
                case WEST: setDirection(Direction.NORTH); break;
                case EST: setDirection(Direction.SOUTH); break;
            }
        }
    }

    public void snakeString(){
        System.out.println("Current snake position  !");
        for (Part part : body){
            System.out.println(part.getPosition().x + " " + part.getPosition().y);
        }
    }

}
