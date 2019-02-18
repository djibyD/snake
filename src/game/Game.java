package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Brick;
import model.Position;
import model.Snake;

public class Game  extends JFrame {
	
	private Snake snake;
	
	public Game() {
		super();
		snake = new Snake();
		
		this.setTitle("Snake");
		this.setSize(new Dimension(900, 700));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Game Zone
		JPanel gameZonePanel = new JPanel(new BorderLayout());
		gameZonePanel.setSize(800, 600);
		//gameZonePanel.setBackground(Color.GRAY);
		
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
		this.getContentPane().add(gameZonePanel);
		this.getContentPane().add(menuPanel, BorderLayout.SOUTH);
		this.setVisible(true);

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
	
	public void play() {
		while(true) {
			this.snake.stepForward();
			paint(getGraphics());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
		}
	}
	
}
