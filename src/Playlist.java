public class Playlist {

    private Video[] videoList; // max vids 10
    private int numVids = 0;

    public Playlist() {
        this.videoList = new Video[10];
        this.numVids = 0;

    }

    public Playlist(Video[] videoList) {
        this.videoList = videoList;
        this.numVids = videoList.length;
    }

    // sorts the videoList and return sorted videoList
    public Video[] sortList() {
        for (int i = 0; i < numVids; i++) {
            for (int j = i; j < numVids; j++) {
                if (videoList[i].getDatePosted().compareDates(videoList[j].getDatePosted()) < 0) { // if second is more recent
                    Video temp = videoList[i];
                    videoList[i] = videoList[j];
                    videoList[j] = temp;
                }
            }
        }
        return videoList;
    }

    public void addVideo(Video vid) {
        Video[] newList = new Video[numVids + 1];
        for (int i = 0; i < numVids; i++) {
            newList[i] = videoList[i];
        }
        newList[numVids] = vid;
        videoList = newList;
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
        for (int i = 0; i < videoList.length; i++) {
            if (videoList[i].getTitle().equals(title)) {
                index = i;
                found = true;
                break;
            }
        }

        for (int i = index; i < videoList.length-1; i++) {
            videoList[i] = videoList[i+1];
        }
        if (found) {
            numVids--;
            return true;
        } else {
            return false;
        }
    }

    public void clearList() {
        videoList = new Video[numVids];
        numVids = 0;
    }

    public int getNumVids() {
        return numVids;
    }

    public Video[] getVideoList() {
        return videoList;
    }

    public void setNumVids(int numVids) {
        this.numVids = numVids;
    }

    public void setVideoList(Video[] videoList) {
        this.videoList = videoList;
    }

    public String toString() {
        String str = "Number of videos: " + numVids + "\n";

        if (numVids == 0) {
            str += "{Empty}";
            return str;
        }

        for (int i = 0; i < numVids; i++) {
            str += videoList[i].toString() + "\n";
        }
        return str;
    }
}
