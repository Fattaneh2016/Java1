
public class fati1 {

	public static void main(String[] args) {
		 
        // months[i] = name of month i
        String[] months = {
            "",                               // leave empty so that months[1] = "January"
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };

        // days[i] = number of days in month i
        int[] days = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };
        
     // check for leap year
    //    if (month == 2 && isLeapYear(year)) days[month] = 29;

     // return true if the given year is a leap year
        
        
        // print calendar header
       // System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        
		System.out.println(day(2,1,2017));
		
	    }
	public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
	}

    // return true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        if  ((year % 4 == 0) && (year % 100 != 0)) return true;
        if  (year % 400 == 0) return true;
        return false;
    }
    
	
}