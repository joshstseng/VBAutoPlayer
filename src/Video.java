import java.awt.*;
import java.net.URI;
//import java.util.Date;

public class Video {

    private URI uri;
    private Date datePosted;

    public Video(URI uri, Date datePosted) {
        this.uri = uri;
        this.datePosted = datePosted;
    }

    public URI getUri() {
        return uri;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    /*
    * opens webpage with a given uri
    * uses desktops default browser
    * exceptions are caught and stack trace is printed
    * returns true on success
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

    // TODO
    public static void sortList(Video videoList[]) {

    }


}
