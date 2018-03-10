import java.util.ArrayList;
import java.util.Scanner;


public class atiya {
	public static void main(String[]args) {
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"
				};
		int[][] temps=new int[6][7];
		for(int i=0;i<myMonth.length;i++){
			CreateCalenderHeader(myMonth[i],"2017");
			System.out.println();
			CreateCalendar(temps ,daysInMonth(i+1));
			System.out.println();
			}
		boolean option = true;
		ArrayList<String> month = new ArrayList<String>();
		ArrayList<Integer> days = new ArrayList<Integer>();
		ArrayList<String> event = new ArrayList<String>();
		while(option) {
			Scanner console = new Scanner (System.in);
		System.out.println("What month do you want to add an event?");
		int date = console.nextInt();
		month.add(myMonth[(date-1)]);
		System.out.println("What day do you want to add an event?");
		int day = console.nextInt();
		days.add(day);
		System.out.println("Please enter the descirption and hours the event will take place.");
		String timeplace = console.nextLine();
		String timeplace2 = console.nextLine();
		event.add(timeplace2);
		
		System.out.println("This event" + " " + " " + "has been scheduled on day" + " " + day + " " + "of" + " " + myMonth[(date-1)] + "." );
		System.out.println(month);
		System.out.println(days);
		System.out.println(event);
		System.out.println("Are there any other events that you wish to add?" + " " + "(yes/no)");
		String yesno = console.next();
		if(yesno == "no") {
			option = false;
		}
		else {
			option = true;
		}
		}

		}
	private static void CreateCalenderHeader(String month,String year) {
		System.out.printf( "%15s" , month);
		System.out.println();
		String[] myWeek={"Sun" ,"Mon" , "Tue" ,"Wed" ,"Thu" , "Fri" , "Sat"};
		for(int i=0;i<myWeek.length;i++){
			System.out.printf("%2s ",myWeek[i]);
			}
		System.out.println();
		}
	private static void CreateCalendar(int[][] grid ,int monthDays ) {
		int k=0;
		for (int i=0 ;i<grid.length; i++){
			for (int j=0;j<grid[i].length; j++){
				int m=j+k+1;
				if (m<=monthDays){
					System.out.printf( " %2d " , grid[i][j]=m);
					}else{
						System.out.printf( " %2d " , 0);
						}
				}
			k=k+7;
			System.out.println();
			}
		}
	public static int daysInMonth(int month) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30; // 30 days have September, April, June, and November
			} else if (month == 2) 
			{
				return 28; //  28 days in February in a non-leap year
				}else{
					return 31; // 31 days in all other months
					}
		}


}
