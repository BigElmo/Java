package geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(650, 300);
        setLocation(350, 350);

        JPanel jPanel = new JPanel(new GridLayout(1, 2));
        add(jPanel, BorderLayout.SOUTH);

        JButton exitButton = new JButton("Exit");
        ActionListener close = new CloseActionListener();
        exitButton.addActionListener(close);
        jPanel.add(exitButton);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanel.add(enterButton);


    }
}
