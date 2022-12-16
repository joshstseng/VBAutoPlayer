import java.util.*;
public class Runner {

    Scanner scan;

    public Runner(Scanner scan) {
        this.scan = scan;
    };

    private int input;

    public void welcome() {
        System.out.println("Welcome to Auto Player!");
    }

    public void selectOption() {
        System.out.println("Please select an option:" +
                "\n\t1. Add Video Link" +
                "\n\t2. Remove Video" +
                "\n\t3. Sort the playlist" +
                "\n\t4. Clear the playlist");
    }
}
