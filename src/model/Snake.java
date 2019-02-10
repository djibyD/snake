package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by djiby on 30/12/17.
 */
public class Snake {
	
	private List<Brick> body;
	private Direction direction;
	private Double speed;
	private State state;
	
	public Snake() {
		super();
		body = new ArrayList<>(Arrays.asList(
				new Brick(new Position(450, 350)),
				new Brick(new Position(450, 361)),
				new Brick(new Position(450, 372))
		));
	}

	public Snake(List<Brick> body, Direction direction, Double speed, State state) {
		super();
		this.body = body;
		this.direction = direction;
		this.speed = speed;
		this.state = state;
	}

	public List<Brick> getBody() {
		return body;
	}

	public void setBody(List<Brick> body) {
		this.body = body;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
	public void stepForward() {
		Position head = body.get(0).getPosition();
		int nbBrick = body.size() - 1;
		body.remove(nbBrick);
		Position newHead = new Position(head.getAbcisse(), head.getOrdonnee() + 11);
		body.add(0, new Brick(newHead));
	}
	
}
