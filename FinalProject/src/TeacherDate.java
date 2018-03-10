// Represents a calendar year/month/day date.

import java.util.*;


public class TeacherDate {
	
	 public static void main(String[] args) {
		 
	 }
    // constants
    private static final int JANUARY =  1;
    private static final int FEBRUARY =  2;
    private static final int DECEMBER = 12;
    private static final int START_YEAR = 1753;
    private static final int DAYS_PER_WEEK = 7;
    private static final String[] DAY_NAMES = {"Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_PER_MONTH = { -1,
    //   1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,
    };

    // Helping method; returns the number of days since the epoch (1/1/1730).
    public static int getDaysSinceEpoch() {
        return (int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
    }

    // fields
    
    private int year;
    private int month;
    private int day;

    // constructor(s)
    
    // Constructs a new TeacherDate to represent the specified year/month/day.
    public TeacherDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

        if (year < START_YEAR) {
            throw new IllegalArgumentException(this + " year too small: " + year);
        }
        if (month < JANUARY || month > DECEMBER) {
            throw new IllegalArgumentException(this + " month out of range: " + month);
        }
        if (day < 1 || day > this.getDaysInMonth()) {
            throw new IllegalArgumentException(this + " day out of range: " + day);
        }
    }
    
    // Constructs a new TeacherDate to represent today.
    public TeacherDate() {
        this(1970, JANUARY, 1);
        int daysSinceEpoch = getDaysSinceEpoch();
        for (int i = 0; i < daysSinceEpoch; i++) {
            this.nextDay();
        }
    }
    
    // methods
    
    // Returns whether the given object is a TeacherDate that refers to the
    // same year/month/day as this TeacherDate.
    public boolean equals(Object o) {
        // a well-behaved equals method returns false for null and non-Dates
        if (o == null || !(o instanceof TeacherDate)) {
            return false;
        }
        
        TeacherDate other = (TeacherDate) o;
        return this.day == other.day && this.month == other.month &&
               this.year == other.year;
    }
    
    // Returns this TeacherDate's day.
    public int getDay() {
        return this.day;
    }
    
    // Returns this TeacherDate's month.
    public int getMonth() {
        return this.month;
    }
    
    // Returns this TeacherDate's year.
    public int getYear() {
        return this.year;
    }

    // Returns the day of the week on which this TeacherDate occurred,
    // such as "Sunday" or "Wednesday".
    // Hint: 1753/1/1 was a Monday (1)
    public String getDayOfWeek() {
        int dayIndex = 1;
        TeacherDate temp = new TeacherDate(START_YEAR, JANUARY, 1);
        while (!temp.equals(this)) {
            temp.nextDay();
            dayIndex = (dayIndex + 1) % DAYS_PER_WEEK;
        }
        
        return DAY_NAMES[dayIndex];
    }
    
    // Returns whether this TeacherDate occurred during a leap year.
    // Leap years are every fourth year, except those that are
    // divisible by 100 and not by 400.
    public boolean isLeapYear() {
        return (this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0);
    }
    
    // Advances this TeacherDate to the next day.
    // This may cause a wrap-around into the next month or year.
    public void nextDay() {
        this.day++;
        if (this.day > this.getDaysInMonth()) {
            // wrap to next month
            this.month++;
            this.day = 1;
            if (this.month > DECEMBER) {
                // wrap to next year
                this.year++;
                this.month = JANUARY;
            }
        }
    }
    
    // Returns a String representation of this TeacherDate, such as "2005/9/22".
    public String toString() {
        return this.year + "/" + this.month + "/" + this.day;
    }

    // A helper method to return the number of days in this TeacherDate's month.
    private int getDaysInMonth() {
        int result = DAYS_PER_MONTH[this.month];
        if (this.month == FEBRUARY && this.isLeapYear()) {
            result++;
        }
        return result;
    }
}
