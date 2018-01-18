import model.Direction;
import vue.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by djiby on 28/12/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello snake !");
        JFrame window = new JFrame("Snake");
        window.setSize(800, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());
        JButton stopButton = new JButton("stop");
        stopButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().stop();
            }
        });

        JButton moveButton = new JButton("move");
        moveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().move(panel);
            }
        });

        JButton leftButton = new JButton("left");
        leftButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().left();
                System.out.println("Change direction to left: " + panel.getSnake().getDirection());
            }
        });

        JButton rightButton = new JButton("right");
        rightButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().right();
                System.out.println("Change direction to right: " + panel.getSnake().getDirection());
            }
        });

        JComponent menu = new Panel();
        menu.setLayout(new GridLayout(1, 2));
        menu.add(moveButton);
        menu.add(stopButton);
        menu.add(leftButton);
        menu.add(rightButton);

        panel.add(menu, BorderLayout.SOUTH);

        window.setContentPane(panel);
        window.setVisible(true);
    }
}
