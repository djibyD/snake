package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.javafx.geom.Ellipse2D;

import model.Brick;
import model.Direction;
import model.Position;
import model.Snake;
import model.State;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Game  extends JFrame {

	private Snake snake;
	private int foodQuantity = 10;
	private List<Brick> food = new ArrayList<Brick>();

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
		graphics2d.drawRect(40, 40, 800, 600);

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
			Position pieceOfFood = new Position((random.nextInt(80) + 5) * 10, (random.nextInt(60) + 5) * 10);
			food.add(new Brick(pieceOfFood));
		}
	}

	public boolean isNearFood(Brick snakeHead, Brick food) {
		return Math.sqrt(Math.pow(snakeHead.getPosition().getAbcisse() - food.getPosition().getAbcisse(), 2.0) 
				+ Math.pow(snakeHead.getPosition().getOrdonnee() - food.getPosition().getOrdonnee(), 2.0)) <= 5;
	}

	public void eatAPieceOfFood() {
		for(Brick pieceOfFood: food) {
			if(isNearFood(this.snake.getBody().get(0), pieceOfFood)) {
				food.remove(pieceOfFood);
				this.snake.eat();
				break;
			}
		}
	}

	public boolean hitTheWall(Position position, Position topLeft, Position bottomRight) {
		if( position.getAbcisse() == topLeft.getAbcisse() || position.getOrdonnee() == topLeft.getOrdonnee()
				|| position.getAbcisse()+10 == bottomRight.getAbcisse() || position.getOrdonnee()+10 == bottomRight.getOrdonnee()) {
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
