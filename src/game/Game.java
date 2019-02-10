package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

import model.Brick;
import model.Position;
import model.Snake;

public class Game  extends JFrame implements Runnable {
	
	private Snake snake;
	
	public Game() {
		super();
		snake = new Snake();
		
		this.setTitle("Snake");
		this.setSize(new Dimension(900, 700));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//Painting
		paint(getGraphics());
		run();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.RED);
		for(Brick brick : snake.getBody()) {
			graphics2d.fillRect(brick.getPosition().getAbcisse(), brick.getPosition().getOrdonnee(), 10, 10);
		}
	}

	@Override
	public void run() {
		while(true) {
			System.out.println("Hello snake!");
			this.snake.stepForward();
			this.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
