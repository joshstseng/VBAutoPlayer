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

            Video avpVideo = new Video(avpURL, avpDate);
            Video oosVideo = new Video(oosURI, oosDate);
            Video ncaaVideo = new Video(ncaaURI, ncaaDate);

            Video[] videoList = {avpVideo, oosVideo, ncaaVideo};
            videoList = Video.sortList(videoList);

            for (int i = 0; i < videoList.length; i++) {
                System.out.println(videoList[i]);
                System.out.println();
            }

            System.out.println("Title of oosVideo: " + oosVideo.getTitle());

            /*
            URI test = new URI("https://stackoverflow.com/questions/10967451/open-a-link-in-browser-with-java-button");
            Video.openWebpage(test);
            */


           /* URL oracle = new URL("https://www.youtube.com/watch?v=EqenuNuI16o&ab_channel=OutofSystem");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            System.out.println("testing:");
            String inputLine;
            int lineNum = 0;
            while ((inputLine = in.readLine()) != null) {
                //System.out.println(inputLine);
                if (inputLine.contains("Dana Rettke on Wisconsin")) {
                    System.out.println("\nfound: Dana Rettke on Wisconsin \nline: " + lineNum);
                    //System.out.println("\nline: \n" + inputLine);

                    int titleIndexBegin = inputLine.indexOf("<title>");
                    int titleIndexEnd = inputLine.indexOf("</title>");
                    System.out.println("title begin index: " + titleIndexBegin);
                    System.out.println("title end index: " + titleIndexEnd);

                    String vidTitle = inputLine.substring(titleIndexBegin + 7, titleIndexEnd);
                    System.out.println("\ntitle: " + vidTitle);

                    break;
                }
                lineNum++;
            }
            in.close();*/
            /*
                end test
             */


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}