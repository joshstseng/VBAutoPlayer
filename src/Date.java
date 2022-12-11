/*
    class Date uses military time for easier comparisons
    between videos
 */

public class Date {

    int month;
    int day;
    int year;
    int hour;
    int minute;

    public Date() {
        month = 1;
        day = 1;
        year = 2000;
        hour = 0;
        minute = 0;
    }

    public Date(int month, int day, int year, int hour, int minute) {
        this.month = month;
        this.day = day;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }

    // compare year->month->day->hour->minute
    // TODO
    public Date returnRecent(Date date1, Date date2) {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

}
