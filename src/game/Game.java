package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Game  extends JFrame {
	
	public Game() {
		super();
		this.setTitle("Snake");
		this.setSize(new Dimension(700, 500));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//Painting
		paint(getGraphics());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setColor(Color.RED);
		graphics2d.fillRect(350, 250, 20, 20);
	}
	
	
	
}
