package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Brick;
import model.Direction;
import model.Position;
import model.Snake;
import model.State;
import utils.Utils;

public class Game  extends JFrame {

	private Snake snake;
	private int foodQuantity = 10;
	private List<Brick> food = new ArrayList<Brick>();
	private int gameZoneWidth = 800;
	private int gameZoneHeight = 600;
	private Position gameZonePosition = new Position(50, 50);
	private int brickSize = 10;

	public Game() {
		super();
		snake = new Snake();

		this.setTitle("Snake");
		this.setSize(new Dimension(900, 700));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Menu
		JButton turnLeftButton = new JButton("Left");
		turnLeftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.toTheLeft();
			}
		});
		JButton turnRightButton = new JButton("Right");
		turnRightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snake.toTheRight();
			}
		});
		JPanel menuPanel = new JPanel();
		menuPanel.add(turnLeftButton);
		menuPanel.add(turnRightButton);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(menuPanel, BorderLayout.SOUTH);

		//Serve food
		serveFood();

		this.setVisible(true);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;

		//Game zone
		graphics2d.setColor(Color.RED);
		//graphics2d.setStroke(new BasicStroke(3));
		graphics2d.drawRect(50, 50, this.gameZoneWidth, this.gameZoneHeight);

		//restore stroke
		//graphics2d.setStroke(defaultStroke);

		//serve food
		graphics2d.setColor(Color.BLUE);
		for(Brick brick : food) {
			graphics2d.fillRect(brick.getPosition().getAbcisse(), brick.getPosition().getOrdonnee(), 9, 9);
		}

		//Draw snake
		graphics2d.setColor(Color.RED);
		for(Brick brick : snake.getBody()) {
			graphics2d.fillRect(brick.getPosition().getAbcisse(), brick.getPosition().getOrdonnee(), 9, 9);
		}

		//Draw Impact of hitting the wall
		if(this.snake.getState().equals(State.STOPPED)) {
			Position snakeHead = this.snake.getBody().get(0).getPosition();
			drawSplash(graphics2d, snakeHead, snake.getDirection());
		}
	}

	public void play() {
		while(this.snake.getState().equals(State.MOVING)) {
			if(!hitTheWall(this.snake.getHead(), new Position(40, 40), new Position(840, 640))) {
				this.snake.stepForward();
				eatAPieceOfFood();
			}
			this.repaint();
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

	public void serveFood() {
		Random random = new Random();
		for(int i =0; i<this.foodQuantity; i++) {
			int min = this.brickSize+50;
			Position pieceOfFood = new Position(((((random.nextInt((this.gameZoneWidth - this.brickSize) + 1 - min) + min)/10) + 5) * 10),
					(((random.nextInt((this.gameZoneHeight - this.brickSize)+ 1 - min) + min)/10) + 5) * 10);
			System.out.println(pieceOfFood.toString());
			food.add(new Brick(pieceOfFood));
		}
	}

	public void eatAPieceOfFood() {
		for(Brick pieceOfFood: food) {
			if(Utils.distanceLessThan(this.snake.getBody().get(0).getPosition(), pieceOfFood.getPosition())<= 5.0) {
				food.remove(pieceOfFood);
				this.snake.setTimeToEat(true);
				break;
			}
		}
	}

	public boolean hitTheWall(Position position, Position topLeft, Position bottomRight) {
		if( position.getAbcisse() == this.gameZonePosition.getAbcisse() || position.getOrdonnee() == this.gameZonePosition.getOrdonnee()
				|| position.getAbcisse()+this.brickSize == this.gameZonePosition.getAbcisse() + this.gameZoneWidth || 
				position.getOrdonnee()+this.brickSize == this.gameZonePosition.getOrdonnee() + this.gameZoneHeight) {
			this.snake.setState(State.STOPPED);
			return true;
		} else {
			return false;
		}
	}

	private void drawSplash(Graphics2D graphics2d, Position position, Direction direction) {
		switch (direction) {
		case NORTH:
			graphics2d.fillOval(position.getAbcisse()-5, position.getOrdonnee(), 20, 20);
			break;
		case SOUTH:
			graphics2d.fillOval(position.getAbcisse()-5, position.getOrdonnee()-10, 20, 20);
			break;
		case WEST:
			graphics2d.fillOval(position.getAbcisse(), position.getOrdonnee()-5, 20, 20);
			break;
		case EAST:
			graphics2d.fillOval(position.getAbcisse()-10, position.getOrdonnee()-5, 20, 20);
			break;
		}
	}

}
