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
    // if exactly same, returns this
    public Date compareDates(Date date) {
        if (this.year > date.getYear()) {
            return this;
        } else if (this.year < date.getYear()) {
            return date;
        } else {
            if (this.month > date.getMonth()) {
                return this;
            } else if (this.month < date.getMonth()) {
                return date;
            } else {
                if (this.day > date.getDay()) {
                    return this;
                } else if (this.day < date.getDay()) {
                    return date;
                } else {
                    if (this.hour > date.getHour()) {
                        return this;
                    } else if (this.hour < date.getHour()) {
                        return date;
                    } else {
                        if (this.minute > date.getMinute()) {
                            return this;
                        } else if (this.minute < date.getMinute()) {
                            return date;
                        } else {
                            return this;
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

}
