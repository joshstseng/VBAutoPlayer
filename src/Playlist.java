import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Playlist {

    //private Video[] videoList; // max vids 10
    private ArrayList<Video> videoList = new ArrayList<Video>();
    private int numVids = 0;

    public Playlist() {
        this.numVids = 0;

    }

    public Playlist(ArrayList<Video> videoList) {
        this.videoList = videoList;
        this.numVids = videoList.size();
    }

    // sorts the videoList and return sorted videoList
    public ArrayList<Video> sortList() {
        for (int i = 0; i < numVids; i++) {
            for (int j = i; j < numVids; j++) {
                if (videoList.get(i).getDatePosted().compareDates(videoList.get(j).getDatePosted()) < 0) { // if second is more recent
                    Video temp = videoList.get(i);
                    videoList.set(i, videoList.get(j));
                    videoList.set(j, temp);
                }
            }
        }
        return videoList;
    }

    public void addVideo(Video vid) {
        videoList.add(vid);
        numVids++;
    }

    /*
    removes the video with the given title and shifts other
    videos down an index
    returns true on success and false on fail
     */
    public boolean removeVideo(String title) {
        int index = 0;
        boolean found = false;
        for (int i = 0; i < videoList.size(); i++) {
            if (videoList.get(i).getTitle().equals(title)) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            videoList.remove(index);
            numVids--;
            return true;
        } else {
            return false;
        }
    }

    // goes through the NCAA, OOS, and AVP and gets most recent vids from each and adds to playlist
    public void fillPlaylist() {

        try {
            Video ncaaVid;
            Video oosVid;
            Video avpVid;
            String nextNcaaLink;
            String nextOosLink;
            String nextAvpLink;

            URL ncaaHome = new URL("https://www.youtube.com/@NCAAChampionships/videos");
            URL oosHome = new URL("https://www.youtube.com/@OutofSystemOfficial");
            URL avpHome = new URL("https://www.youtube.com/@avpbeach");

            BufferedReader ncaaIn = new BufferedReader(
                    new InputStreamReader(ncaaHome.openStream()));
            BufferedReader oosIn = new BufferedReader(
                    new InputStreamReader(oosHome.openStream()));
            BufferedReader avpIn = new BufferedReader(
                    new InputStreamReader(avpHome.openStream()));

            String inputLine;
            while ((inputLine = ncaaIn.readLine()) != null) {
                if (inputLine.contains("/watch?")) {
                    int ncaaBegin = inputLine.indexOf("/watch?"); //index of the video link
                    int ncaaEnd = ncaaBegin + 20;
                    nextNcaaLink = "https://www.youtube.com" + inputLine.substring(ncaaBegin, ncaaEnd);
                    ncaaVid = new Video(nextNcaaLink);
                    videoList.add(ncaaVid);
                    numVids++;
                    break;
                }
            }

            while ((inputLine = oosIn.readLine()) != null) {
                if (inputLine.contains("/watch?")) {
                    int oosBegin = inputLine.indexOf("/watch?"); //index of the video link
                    int oosEnd = oosBegin + 20;
                    nextOosLink = "https://www.youtube.com" + inputLine.substring(oosBegin, oosEnd);
                    oosVid = new Video(nextOosLink);
                    videoList.add(oosVid);
                    numVids++;
                    break;
                }
            }

            while ((inputLine = avpIn.readLine()) != null) {
                if (inputLine.contains("/watch?")) {
                    int avpBegin = inputLine.indexOf("/watch?"); //index of the video link
                    int avpEnd = avpBegin + 20;
                    nextAvpLink = "https://www.youtube.com" + inputLine.substring(avpBegin, avpEnd);
                    avpVid = new Video(nextAvpLink);
                    videoList.add(avpVid);
                    numVids++;
                    break;
                }
            }

            /*
            while ((inputLine = oosIn.readLine()) != null) {
                if (inputLine.contains(""))
            }*/

        } catch (MalformedURLException e) {
            System.out.println("Invalid homepage link");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            System.out.println("Invalid watch link from home page");
            e.printStackTrace();
        }


    }

    public void clearList() {
        videoList.clear();
        numVids = 0;
    }

    public int getNumVids() {
        return numVids;
    }

    public ArrayList<Video> getVideoList() {
        return videoList;
    }

    public void setNumVids(int numVids) {
        this.numVids = numVids;
    }

    public void setVideoList(ArrayList<Video> videoList) {
        this.videoList = videoList;
    }

    public String toString() {
        String str = "Number of videos: " + numVids + "\n";

        if (numVids == 0) {
            str += "{Empty}";
            return str;
        }

        for (int i = 0; i < numVids; i++) {
            str += videoList.get(i).toString() + "\n";
        }
        return str;
    }
}
