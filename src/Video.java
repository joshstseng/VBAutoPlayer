import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import java.util.Date;

public class Video {

    private String title;
    private URI uri;
    private Date datePosted;

    public Video(URI uri, Date datePosted) throws MalformedURLException {
        this.uri = uri;
        this.datePosted = datePosted;
        this.title = stripTitle(uri.toURL());
    }

    public Video(URL url, Date datePosted) throws MalformedURLException, URISyntaxException {
        this.uri = url.toURI();
        this.datePosted = datePosted;
        this.title = stripTitle(uri.toURL());
    }

    public Video(String link) throws URISyntaxException, MalformedURLException {
        try {
            URI uri = new URI(link);
            this.uri = uri;

            Date d = new Date();
            this.datePosted = d;
            this.title = stripTitle(uri.toURL());

        } catch (Exception e) {
            if ((e instanceof URISyntaxException) | (e instanceof MalformedURLException)) {
                System.out.println("Link is invalid");
            } else if (e instanceof IllegalArgumentException) {
                System.out.println("Link is invalid");
            } else {
                e.printStackTrace();
            }
        }

    }

    public URI getUri() {
        return uri;
    }

    public String getTitle() {
        return title;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    /*
    * opens webpage with a given uri
    * uses desktops default browser
    * exceptions are caught and stack trace is printed
    * returns true on success
    * overloaded with url
    * */
    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    // using insertion sort
    public static Video[] sortList(Video videoList[]) {
        for (int i = 0; i < videoList.length; i++) {
            for (int j = i; j < videoList.length; j++) {
                if (videoList[i].getDatePosted().compareDates(videoList[j].getDatePosted()) < 0) { // if second is more recent
                    Video temp = videoList[i];
                    videoList[i] = videoList[j];
                    videoList[j] = temp;
                }
            }
        }
        return videoList;
    }

    public String stripTitle(URL url) {
        String vidTitle = null;
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                if (inputLine.contains("<title>")) {
                    int titleIndexBegin = inputLine.indexOf("<title>");
                    int titleIndexEnd = inputLine.indexOf("</title>");
                    vidTitle = inputLine.substring(titleIndexBegin + 7, titleIndexEnd);
                    break;
                }
            }
            if (vidTitle == null) {
                in.close();
                System.out.println("Title not found in the HTML content");
                throw (new Exception("Title not found in the HTML content"));
            }
            in.close();
            return vidTitle;
        } catch (Exception e) {
            e.printStackTrace();
            return vidTitle; // null
        }
    }

    public String toString() {
        String str = "URI link: " + uri.toString() + "\n";
        str += "Title: " + getTitle() + "\n";
        str += "Date: " + datePosted.toString() + "\n";
        return str;
    }

}
