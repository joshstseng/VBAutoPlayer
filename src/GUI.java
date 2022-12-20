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

            panel.setSize(1000, 750);
            frame.setPreferredSize(new Dimension(1000, 750));
            playlistLabel.setPreferredSize(new Dimension(1000, 5));
            addButton.setPreferredSize(new Dimension(40, 40));

            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panel.add(addButton);
            panel.add(playlistLabel);
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String videoLink = JOptionPane.showInputDialog("Paste video link: ");
                        if (videoLink == null) {
                            return;
                        } else {

                            if (runner.getPlaylist().getNumVids() == 0) {
                                runner.addVideoLink(videoLink);
                                playlistLabel.setText(runner.guiLabelTitles(0));
                            } else {
                                runner.addVideoLink(videoLink);
                                panel.add(new JLabel(runner.guiLabelTitles(numVids)));
                                showFrame();
                            }

                        }
                    } catch (MalformedURLException | URISyntaxException r) {
                        r.printStackTrace();
                    }
                }
            });

            showFrame();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFrame() {
        this.frame.pack();
        this.frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
