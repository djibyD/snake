package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

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
				new Brick(new Position(400, 300)),
				new Brick(new Position(400, 310)),
				new Brick(new Position(400, 320))
		));
		this.direction = Direction.NORTH;
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
		Position newHead;
		switch (this.direction) {
		case NORTH:
			newHead = new Position(head.getAbcisse(), head.getOrdonnee() - 10);
			body.add(0, new Brick(newHead));
			break;
		case SOUTH: 
			newHead = new Position(head.getAbcisse(), head.getOrdonnee() + 10);
			body.add(0, new Brick(newHead));
			break;
		case EAST:
			newHead = new Position(head.getAbcisse() + 10, head.getOrdonnee());
			body.add(0, new Brick(newHead));
			break;
		case WEST:
			newHead = new Position(head.getAbcisse() - 10, head.getOrdonnee());
			body.add(0, new Brick(newHead));
			break;
		default:
			break;
		}
		//System.out.println("abs: " + newHead.getAbcisse() + " ord: " + newHead.getOrdonnee());
	}
	
	public void toTheLeft() {
		switch (this.direction) {
		case NORTH: this.direction = Direction.WEST;
			break;
		case SOUTH: this.direction = Direction.EAST;
			break;
		case WEST: this.direction = Direction.SOUTH;
			break;
		case EAST: this.direction = Direction.NORTH;
			break;
		default:
			break;
		}
	}
	
	public void toTheRight() {
		switch (this.direction) {
		case NORTH: this.direction = Direction.EAST;
			break;
		case SOUTH: this.direction = Direction.WEST;
			break;
		case WEST: this.direction = Direction.NORTH;
			break;
		case EAST: this.direction = Direction.SOUTH;
			break;
		default:
			break;
		}
	}
	
	public void eat() {
		Position head = body.get(0).getPosition();
		Position newHead;
		switch (this.direction) {
		case NORTH:
			newHead = new Position(head.getAbcisse(), head.getOrdonnee() - 10);
			body.add(0, new Brick(newHead));
			break;
		case SOUTH: 
			newHead = new Position(head.getAbcisse(), head.getOrdonnee() + 10);
			body.add(0, new Brick(newHead));
			break;
		case EAST:
			newHead = new Position(head.getAbcisse() + 10, head.getOrdonnee());
			body.add(0, new Brick(newHead));
			break;
		case WEST:
			newHead = new Position(head.getAbcisse() - 10, head.getOrdonnee());
			body.add(0, new Brick(newHead));
			break;
		default:
			break;
		}
		
	}
	
}
