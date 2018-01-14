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
        JButton stopButton = new JButton("stop snake");
        stopButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().stop();
            }
        });

        JButton moveButton = new JButton("move snake");
        moveButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getSnake().move();
            }
        });

        JComponent menu = new Panel();
        menu.setLayout(new GridLayout(1, 2));
        menu.add(moveButton);
        menu.add(stopButton);

        panel.add(menu, BorderLayout.SOUTH);

        window.setContentPane(panel);
        window.setVisible(true);
    }
}
