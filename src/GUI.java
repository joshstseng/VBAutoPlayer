import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    int numVids;
    Runner runner;
    JFrame frame;
    JPanel panel;
    JButton addButton = new JButton("add Video");

    public GUI() {
        frame = new JFrame("Auto Player");
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(addButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

    }

    public void actionPerformed(ActionEvent e) {

    }
}
