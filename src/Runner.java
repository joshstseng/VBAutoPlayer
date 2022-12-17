import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.*;
public class Runner {

    // TODO
    // current video will always be the one in the front of the playlist
    // once it finishes video - removes video from the playlist and opens next link

    public Scanner scan;
    public Playlist playlist;
    private int option;
    private String input;

    public Runner(Scanner scan, Playlist playlist) {
        this.scan = scan;
        this.playlist = playlist;
    };


    public void welcome() {
        System.out.println("Welcome to Auto Player!");
    }

    // returns true on close - false otherwise
    public boolean selectOption() throws MalformedURLException, URISyntaxException {
        try {
            System.out.println("Select an option:" +
                    "\n\t1. Add Video Link" +
                    "\n\t2. Remove Video" +
                    "\n\t3. Print the playlist" +
                    "\n\t4. Sort the playlist" +
                    "\n\t5. Clear the playlist" +
                    "\n\t6. Close the player");
            option = scan.nextInt();
            scan.nextLine(); // next line? skip the \n

            if (option == 1) {
                return addVideoLink();

            } else if (option == 2) {
                if (removeVideo()) {
                    System.out.println("Removed: " + input);
                } else {
                    System.out.println("Title " + input + " not found. Nothing removed");
                }
                return false;

            } else if (option == 3) {
                printPlaylist();
                return false;

            } else if (option == 4) {
                sortPlaylist();
                return false;

            } else if (option == 5) {
                clearPlaylist();
                return false;

            } else if (option == 6) {
                return closeRunner();

            } else {
                System.out.println("Please select a valid option [1-6]");
                return selectOption();
            }
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Please select a valid option [1-6]");
                scan.nextLine();
                return false;
            } else {
                e.printStackTrace();
                return true; // close
            }
        }
    }

    public boolean addVideoLink() throws URISyntaxException, MalformedURLException {

        try {
            System.out.println("Paste the video link to add: ");
            input = scan.nextLine();
            Video newVid = new Video(input);
            playlist.addVideo(newVid);
            System.out.println("Added: " + newVid.getTitle());
            return false;
        } catch (Exception e) {
            if ((e instanceof URISyntaxException) | (e instanceof MalformedURLException) | (e instanceof IllegalArgumentException)) {
                System.out.println("Link is invalid");
            } else {
                e.printStackTrace();
                return true;
            }
            return false;
        }
    }

    public boolean removeVideo() {

        if (playlist.getNumVids() == 0) {
            System.out.println("The playlist is empty. No videos removed");
            return false;
        }

        System.out.println("Enter the title of the video to remove: ");
        input = scan.nextLine();
        boolean removed = playlist.removeVideo(input);
        return removed;
    }

    public void printPlaylist() {
        System.out.println(playlist);
    }

    public void sortPlaylist() {
        System.out.println("Sorting playlist");
        playlist.sortList();
    }

    public void clearPlaylist() {
        playlist.clearList();
        System.out.println("Cleared playlist");
    }

    public boolean closeRunner() {
        System.out.println("See you next time!");
        scan.close();
        return true;
    }


}
