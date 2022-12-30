import java.util.Scanner;

/**
 * current TODO:
 * finish swapping functionality
 *      I have edited the HighlightedButton class
 *      now I have to change the Labels that are dyncamically created into HighlightedButtons
 *          basically, change all the labels in all the functions into HighlightedButtons
 */

public class Main {
    public static void main(String[] args) {

        try {

            // RUNNER AUTOMATION
            Scanner scan = new Scanner(System.in);
            Playlist playlist = new Playlist();

            Runner runner = new Runner(scan, playlist);

            //GUI gui = new GUI(runner);
            guiUpdate gui = new guiUpdate(runner);

            runner.welcome();

            boolean closed = false;

            while (!closed) {
                closed = runner.selectOption();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}