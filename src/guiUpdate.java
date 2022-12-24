import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class guiUpdate extends Frame {

    ArrayList<String> labelTitles = new ArrayList<String>();

    Runner runner;
    Panel top;
    Panel middle;
    Panel bot;
    Button fillButton;
    Button clearButton;
    Label msgLabel;
    TextField videoNameTF;

    String blank = "";
    String error = "Link is invalid!";
    String success = "Video added!";

    public guiUpdate(Runner runner) {

        this.runner = runner;

        setLayout(new GridLayout(3, 1));

        top = new Panel(new FlowLayout(FlowLayout.CENTER));
        middle = new Panel(new FlowLayout(FlowLayout.CENTER));
        bot = new Panel(new GridLayout(10, 1));

        // TODO action listeners for all buttons and text field

        // top components
        fillButton = new Button("Fill");
        fillButton.addActionListener(new fillButtonListener());

        clearButton = new Button("Clear");
        clearButton.addActionListener(new clearButtonListener());

        top.add(fillButton);
        top.add(clearButton);

        // middle components
        msgLabel = new Label("");


        videoNameTF = new TextField(50);
        videoNameTF.addActionListener(new videoTFListener());

        middle.add(msgLabel); // add blank label
        middle.add(videoNameTF); // add text field

        // bottom components
        // labels

        // Frame
        add(top);
        add(middle);
        add(bot);
        setTitle("Auto Player");
        setSize(750, 500);
        setVisible(true);

        addWindowListener(new MyWindowListener());
    }

    private class fillButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            runner.getPlaylist().fillPlaylist();
            for (int i = runner.getPlaylist().getNumVids() - 3; i < runner.getPlaylist().getNumVids(); i++) {
                String vidTitle = runner.getPlaylist().getVideoList().get(i).getTitle();
                labelTitles.add(vidTitle);
                bot.add(new Label(vidTitle));
            }
            bot.revalidate();
            bot.repaint();
            bot.setVisible(true);
        }
    }

    private class clearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Component[] componentList = bot.getComponents();

            for (Component c : componentList) {
                if (c instanceof Label) {
                    bot.remove(c);
                }
            }
            labelTitles.clear();
            runner.clearPlaylist();
            bot.revalidate();
            bot.repaint();
            bot.setVisible(true);
        }
    }

    private class videoTFListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String link = videoNameTF.getText();
                runner.addVideoLink(link);
                String title = runner.getPlaylist().getVideoList().get(labelTitles.size()).getTitle();
                labelTitles.add(title);
                bot.add(new Label(title));
                videoNameTF.setText("");
                msgLabel.setText(success);
                bot.revalidate();
                bot.repaint();
                bot.setVisible(true);
            } catch (Exception l) {
                System.out.println("Link is invalid");
                msgLabel.setText(error);
                l.printStackTrace();
            }
        }
    }

    private class MyWindowListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }


}
