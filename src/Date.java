/*
    class Date uses military time for easier comparisons
    between videos
 */

public class Date {

    private int month;
    private int day;
    private int year;
    private int hour;
    private int minute;

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

    // compare this to input
    // year->month->day->hour->minute
    // this: 1 -- compared, -1
    // if exactly same, returns 1
    public int compareDates(Date date) {
        if (this.year > date.getYear()) {
            return 1;
        } else if (this.year < date.getYear()) {
            return -1;
        } else {
            if (this.month > date.getMonth()) {
                return 1;
            } else if (this.month < date.getMonth()) {
                return -1;
            } else {
                if (this.day > date.getDay()) {
                    return 1;
                } else if (this.day < date.getDay()) {
                    return -1;
                } else {
                    if (this.hour > date.getHour()) {
                        return 1;
                    } else if (this.hour < date.getHour()) {
                        return -1;
                    } else {
                        if (this.minute > date.getMinute()) {
                            return 1;
                        } else if (this.minute < date.getMinute()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        }
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

    public String toString() {
        String str = String.valueOf(month) + " / " + String.valueOf(day) + " / " + String.valueOf(year) + " @ " + String.valueOf(hour) + ":" + String.valueOf(minute);
        return str;
    }

}
