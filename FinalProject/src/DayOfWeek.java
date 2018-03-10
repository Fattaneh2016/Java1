//  This program calculates what day of the week a given date falls on.

import java.util.*;

public class DayOfWeek {
    public static void main(String[] args) {
        System.out.println("This program will tell you what day of the week");
        System.out.println("a certain date falls on.");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.print("What is the month (1 to 12)? ");
        int month = console.nextInt();
        System.out.print("What is the day (1 to 31)? ");
        int day = console.nextInt();
        System.out.print("What is the year (e.g., 2007)? ");
        int year = console.nextInt();

        int totalDays = sumOfMonths(month) + day + (year - 1) * 365
            + leapDays(month, year);
        day = totalDays % 7;
        System.out.println("Your date falls on a " + dayFor(day));
    }
            
    // returns the number of days before given month not counting leap days
    public static int sumOfMonths(int month) {
        int sum = 0;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                sum += 28;
            } else if (i == 4) {
                sum += 30;
            } else if (i == 6) {
                sum += 30;
            } else if (i == 9) {
                sum += 30;
            } else if (i == 11) {
                sum += 30;
            } else {
                sum += 31;
            }
        }
        return sum;
    }

    // returns the number of leap days between 1/1/1 and the given month/year
    // using the rule that every 4 years is a leap year, except for every
    // 100 years which is not, except for every 400 years which is
    public static int leapDays(int month, int year) {
        // if we're in January or February, don't count leap years from the
        // current year
        if (month <= 2) {
            year--;
        }
        return year / 4 - year/ 100 + year / 400;
    }

    // returns the name of a day of the week where Sunday = 0, Monday = 1,
    // Tuesday = 2, ..., and Saturday = 6
    public static String dayFor(int day) {
        if (day == 0) {
            return "Sunday";
        } else if (day == 1) {
            return "Monday";
        } else if (day == 2) {
            return "Tuesday";
        } else if (day == 3) {
            return "Wednesday";
        } else if (day == 4) {
            return "Thursday";
        } else if (day == 5) {
            return "Friday";
        } else if (day == 6) {
            return "Saturday";
        } else {
            throw new IllegalArgumentException();
        }
    }
}
