import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.*;

public class GUI implements ActionListener {

    Runner runner;
    JFrame frame;
    JPanel panel;
    ArrayList<JLabel> labels = new ArrayList<JLabel>();
    //JLabel playlistLabel = new JLabel("{Empty}");
    JButton playNextButton = new JButton(">>");
    JButton addButton = new JButton("Add Video");
    JButton fillButton = new JButton("Fill Playlist");
    JButton clearButton = new JButton("Clear Playlist");
    JButton removeButton = new JButton("Remove Video"); // temporary TODO

    public GUI(Runner runner) {

        this.runner = runner;

        try {
            frame = new JFrame("Auto Player");
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(4, 10));

            panel.setSize(1000, 750);
            frame.setPreferredSize(new Dimension(1000, 750));
            //playlistLabel.setPreferredSize(new Dimension(5, 5));
            addButton.setPreferredSize(new Dimension(40, 40));
            fillButton.setPreferredSize(new Dimension(40, 40));

            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            panel.add(playNextButton);
            playNextButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String title = runner.getPlaylist().getVideoList().get(0).getTitle();
                    Component[] componentList = panel.getComponents();
                    for (Component c : componentList) {
                        if (c instanceof JLabel) {
                            if (((JLabel) c).getText().equals(title)) {
                                panel.remove(c);
                            }
                        }
                    }
                    panel.revalidate();
                    panel.repaint();
                    runner.playPlaylist();
                    showFrame();
                }
            });

            panel.add(addButton);
            addButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String videoLink = JOptionPane.showInputDialog("Paste video link: ");
                        if (videoLink == null) {
                            return;
                        } else {

                            /*if (runner.getPlaylist().getNumVids() == 0) {
                                runner.addVideoLink(videoLink);
                                playlistLabel.setText(runner.guiLabelTitles(0));
                            } else {*/
                                runner.addVideoLink(videoLink);
                                labels.add(new JLabel(runner.guiLabelTitles(runner.getPlaylist().getNumVids() - 1)));
                                panel.add(labels.get(runner.getPlaylist().getNumVids() - 1));
                                //panel.add(new JLabel(runner.guiLabelTitles(runner.getPlaylist().getNumVids() - 1)));
                                showFrame();
                            //}

                        }
                    } catch (Exception r) {
                        JOptionPane.showMessageDialog(panel, "Link does not exist", "Warning", JOptionPane.WARNING_MESSAGE);
                        //r.printStackTrace();
                    }
                }
            });

            panel.add(fillButton);
            fillButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    runner.getPlaylist().fillPlaylist();
                    for (int i = 3; i > 0; i--) {
                        labels.add(new JLabel(runner.guiLabelTitles(runner.getPlaylist().getNumVids() - i)));
                        panel.add(labels.get(runner.getPlaylist().getNumVids() - i));
                        //panel.add(new JLabel(runner.guiLabelTitles(runner.getPlaylist().getNumVids() - i)));
                    }
                    showFrame();
                }
            });

            panel.add(clearButton);
            clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    Component[] componentList = panel.getComponents();
                    for (Component c : componentList) {
                        if (c instanceof JLabel) {
                            panel.remove(c);
                        }
                    }


                    runner.clearPlaylist();
                    labels.clear();
                    panel.revalidate();
                    panel.repaint();
                    showFrame();
                }
            });

            panel.add(removeButton);
            removeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String title = JOptionPane.showInputDialog("What's the title of the video?");
                    boolean found = false;
                    for (JLabel l : labels) {
                        if (l.getText().equals(title)) {
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        Component componentList[] = panel.getComponents();

                        for (Component c : componentList) {
                            if (c instanceof JLabel) {
                                if (((JLabel) c).getText().equals(title)) {
                                    panel.remove(c);
                                    showFrame();
                                    break;
                                }
                            }
                        }
                        panel.revalidate();
                        panel.repaint();
                        runner.removeVideo(title);
                        labels.remove(title);
                        showFrame();
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
