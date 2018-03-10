import java.util.Arrays;
import java.util.Scanner;


public class MyCalendar {
	public static void main(String[] args) {
		
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};
				
		
		/*Scanner console = new Scanner(System.in);
        System.out.print("What is the month (1 to 12)? ");
        int month = console.nextInt();
        System.out.print("What is the day (1 to 31)? ");
        int day = console.nextInt();
        System.out.print("What is the year (e.g., 2007)? ");
        int year = console.nextInt();
*/
        int totalDays = daysInMonth(1) + 1 + (2017 - 1) * 365
            + leapDays(1, 2017);
        int day = totalDays % 7;
        day=3;
        System.out.println("Your date falls on a " + dayFor(day));
        
        
        
		int[][] temps=new int[5][7];
		
		for(int i=0;i<myMonth.length;i++){
			
			
			//int totalDays = daysInMonth(i) + 1 + (2017 - 1) * 365
		   //         + leapDays(i, 2017);
		   //    int  day = totalDays % 7;
		        
			CreateCalenderHeader(myMonth[i],"2017");
			System.out.println();
			CreateCalendar(temps ,daysInMonth(i+1),day);
			System.out.println();			
			//AddEventToCalender("2017",1,2,"hi");			
		}	
		System.out.println();
		
		//Arrays.fill(temps, 1,3,90);
		//System.out.println(temps);

			
		
	}	
	 public static int leapDays(int month, int year) {
	        // if we're in January or February, don't count leap years from the
	        // current year
	        if (month <= 2) {
	            year--;
	        }
	        return year / 4 - year/ 100 + year / 400;
	    }
	 
		private static void AddEventToCalender(String string, int i, int j,
			String string2) {
		
		
	}

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
		
		public static int SearchCalendar(int[] a, int target) {
			for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] == target) {
			return i;
			}
			}
			return -1;
			}
		
	
	private static void CreateCalenderHeader(String month,String year) {
		System.out.printf( "%17s" , year);
		System.out.println();
		System.out.printf( "%15s" , month); 
		System.out.println();
		String[] myWeek={"Sun" ,"Mon" , "Tue" ,"Wed" ,"Thu" , "Fri" , "Sat"};		
		for(int i=0;i<myWeek.length;i++){
			System.out.printf("%2s ",myWeek[i]);
		}				
		System.out.println();				
	}
	
	
	private static void CreateCalendar(int[][] grid ,int monthDays ,int day ) {		
		int k=0;
		
	        
		for (int i=0 ;i<grid.length; i++){			
			for (int j=0;j<grid[i].length; j++){
				
				
				int m=j+k+1;
				grid[i][j]=m;
				//Arrays.fill(grid, 1, 3, 88);
				if (m<=monthDays){					
					//int totalDays = monthDays + m + (year - 1) * 365;				            
				      //  day = totalDays % 7;	
				
						System.out.printf( " %2d " , grid[i][j]);					
				}else{						
					System.out.printf( " %2d " ,   0);
				}				
			}
			k=k+7;				
			System.out.println();
		}
		//System.out.println(grid[3][1]);
	}
	public static int daysInMonth(int month) {
						
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30; // 30 days have September, April, June, and November
		} else if (month == 2) {
			return 28; // 28 days in February in a non-leap year
		} else {
			return 31; // 31 days in all other months
		}
	}
	
	
	
}
