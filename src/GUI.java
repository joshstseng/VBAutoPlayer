import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class GUI implements ActionListener {

    int numVids;
    Runner runner;
    JFrame frame;
    JPanel panel;
    JLabel playlistLabel = new JLabel("{Empty}");
    JButton addButton = new JButton("add Video");

    public GUI(Runner runner) {

        this.runner = runner;

        try {
            frame = new JFrame("Auto Player");
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(4, 4));
            panel.add(addButton);
            panel.add(playlistLabel);
            addButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    try {
                        String videoLink = JOptionPane.showInputDialog("Paste video link: ");
                        if (videoLink == null) {
                            return;
                        } else {
                            runner.addVideoLink(videoLink);
                        }
                    } catch (MalformedURLException | URISyntaxException r) {
                        r.printStackTrace();
                    }
                }
            });

            panel.setSize(1000, 750);
            frame.setPreferredSize(new Dimension(1000, 750));
            playlistLabel.setPreferredSize(new Dimension(1000, 5));
            addButton.setPreferredSize(new Dimension(40, 40));

            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
