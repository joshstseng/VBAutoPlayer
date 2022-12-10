import java.awt.*;
import java.net.URI;

public class Main {
    public static void main(String[] args) {

        System.out.println("hello");

        try {
            URI test = new URI("https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button");
            Video.openWebpage(test);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}