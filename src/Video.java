import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
//import java.util.Date;

public class Video {

    private String title;
    private URI uri;
    private Date datePosted;
    // TODO length field???

    public Video(URI uri, Date datePosted) {
        this.uri = uri;
        this.datePosted = datePosted;

        // TODO figure out way to strip title from the link
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

    // TODO
    public boolean getTitleFromLink() {
        return true;
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

    public String toString() {
        String str = "URI link: " + uri.toString() + "\n";
        str += "Date: " + datePosted.toString();
        return str;
    }

}
