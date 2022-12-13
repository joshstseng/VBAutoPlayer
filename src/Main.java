import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {

            // test stuff
            Date avpDate = new Date(1, 28, 2005, 7, 30);
            Date oosDate = new Date(11, 29, 2022, 23, 5);
            Date ncaaDate = new Date(12, 10, 2022, 19, 30);

            URI avpURI = new URI("https://www.youtube.com/watch?v=CtDKAvaeF70");
            URI oosURI = new URI("https://www.youtube.com/watch?v=EqenuNuI16o");
            URI ncaaURI = new URI("https://www.youtube.com/watch?v=M4ApIzKjRr0");
            URL avpURL = new URL("https://www.youtube.com/watch?v=CtDKAvaeF70");

            Video avpVideo = new Video(avpURI, avpDate);
            Video oosVideo = new Video(oosURI, oosDate);
            Video ncaaVideo = new Video(ncaaURI, ncaaDate);

            Video[] videoList = {avpVideo, oosVideo, ncaaVideo};
            videoList = Video.sortList(videoList);

            for (int i = 0; i < videoList.length; i++) {
                System.out.println(videoList[i]);
                System.out.println();
            }

            URI test = new URI("https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button");
            Video.openWebpage(test);

            /*
                testing printing the HTML contents of a YT link
                TODO read the proper line from the HTML code of the title
             */

            URL oracle = new URL("https://www.youtube.com/watch?v=dpTPntPASC4&ab_channel=Rekt");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            System.out.println("testing:");
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
            /*
                end test
             */


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}