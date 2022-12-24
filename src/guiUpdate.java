import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guiUpdate extends Frame {

    Runner runner;

    public guiUpdate(Runner runner) {

        this.runner = runner;

        setLayout(new GridLayout(3, 1));

        Panel top = new Panel(new FlowLayout(FlowLayout.CENTER));
        Panel middle = new Panel(new GridLayout(3, 1));
        Panel bot = new Panel(new GridLayout(10, 1));

        // top components
        Button fillButton = new Button("Fill");
        Button clearButton = new Button("Clear");
        top.add(fillButton);
        top.add(clearButton);

        // middle components
        Label blankLabel = new Label("");
        Label errorLabel = new Label("Link is invalid!"); // not added initially
        Label successLabel = new Label("Video added!"); // not added initially
        TextField videoNameTF = new TextField(60);
        Button addButton = new Button("add");
        addButton.setPreferredSize(new Dimension(3, 2));
        middle.add(blankLabel); // add blank label
        middle.add(videoNameTF);
        middle.add(addButton);

        // bottom components
        Label test = new Label("bottom panel");
        bot.add(test);

        // Frame
        add(top);
        add(middle);
        add(bot);
        setTitle("Auto Player");
        setSize(500, 500);
        setVisible(true);

        addWindowListener(new MyWindowListener());

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
