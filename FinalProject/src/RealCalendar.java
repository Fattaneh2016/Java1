

import java.util.Calendar;
import java.util.Scanner;
public class RealCalendar {
	public static final int DAYS_IN_AWEEK=7; 
	
	public static void main(String[] args) {
		
		//get  Instance of  a calendar class and show the current date and time
		Calendar cal = Calendar.getInstance();		
		System.out.println("Today is " + cal.getTime());
	
		System.out.println("**************************");
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};

		//define two dimensional array for creating each month calendar 	
		String[][] grid=new String[5][7];

		//Ask user for calendar year
		Scanner console=new Scanner(System.in);
		String updateMonth="";
		int day=0;
		int month=0;
		String description="";
		//ask user to input year
		String year=AskUserForYear();
		//call creatCalendar 
		CreateCalender( grid, year,myMonth);
		
		 
		//Ask User For Event
		boolean option = true;    
		while(option) {

			System.out.println("What month do you want to add an event from ( 1-12 )?");
			month = console.nextInt();

			System.out.println("What day do you want to add an event from ( 1-31 )?");
			day = console.nextInt();

			System.out.println("Please enter the descirption and hours the event will take place.");
			description=console.next();

			System.out.println("Please enter the hours the event will take place.");
			String timeplace = console.next();

			System.out.println("This event" + " " + " " + "has been scheduled on day" + " " + 
					day + " " + "of" + " " + myMonth[month-1] + "." );
			updateMonth=myMonth[month-1];
			System.out.println("Month:" + updateMonth);   
			System.out.println("Day:" + day);
			System.out.println("Time : " + timeplace);
			System.out.println("Description:" + description);

			System.out.println();

			//add event to calendar and update the calendar 
			UpdateCalendar(grid ,daysInMonth(month+1),year,month ,day,description);
			System.out.println();

			//Ask user to type the event note for searching the calendar by event note 
			System.out.println("Search calendar by event note:: " );
			String search = console.next();

			//show calendar 
			String mySearch=SearchCalendar(grid,month,day,search,description);
			System.out.println(" Your note event :: " + mySearch);

			System.out.println(); 

			//ask user if wants to continue adding event to calendar or exit .
			System.out.println("Are there any other events that you wish to add?" + " " + "(Y/N)");
			String yesno = console.next();
			if(yesno.equalsIgnoreCase("N")) {
				option = false;
			}
			else {
				option = true;
			}
		} 
	} 
	public static String AskUserForYear() {
		Scanner console=new Scanner(System.in);
		System.out.print("Please enter a calender year? ");
		return console.next();  
	}
	public static String SearchCalendar(String[][] grid , int month, int day,String search,String description) {
				
		for(int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length; j++){        
				if (grid[i][j].contains("*") && grid[i][j].contains(search))
				{           
					return description;
				}
			}
		}
		return "Not found";
	}
	public static void UpdateCalendar(String[][] grid,int monthDays ,String year, int month,int day ,String description) {
		for (int i=1;i<=100; i++){
			System.out.printf( "%1s" , "*");
		} 
		System.out.println();

		for(int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length; j++){


				if( grid[i][j].equalsIgnoreCase(String.valueOf(day)) ){     
					grid[i][j]= day+ "*" + description;

				}
				if(  grid[i][j].contains("32") || grid[i][j].contains("33") ||
						grid[i][j].contains("34") || grid[i][j].contains("35")){     
					System.out.printf( " %10s " , "_" );    
				}else{
					System.out.printf( " %10s " , grid[i][j]);
				}
			}
			System.out.println(); 
		}
		for (int i=1;i<=100; i++){
			System.out.printf( "%1s" , "*");
		}
	}
	public static void CreateCalender(String[][] grid ,String year,String[] myMonth) {
		

		System.out.printf( "You have selected calender year: %2s\n" , year );
		System.out.println();

		for(int i=0;i<myMonth.length;i++){ 

			//create calendar header for 12 month
			CreateCalenderHeader(myMonth[i],year);
			System.out.println();
			int SundayStart=daysInMonth(i+1)%7;

			CreateCalendarYear( grid, daysInMonth(i+1) , SundayStart);
			System.out.println();       
		} 
		System.out.println();
	} 
	public static void CreateCalendarYear(String[][] grid ,int monthDays ,int mySunday) { 
		int count=0;
		for (int i=0 ;i<grid.length; i++){   
			for (int j=0;j<grid[i].length; j++){
				int row=j+count+1;
				String myRow=Integer.toString(row);   
				grid[i][j]=myRow;

				if (mySunday==1){     
					grid[0][0]="*";
					grid[0][1]="*";
				}
				if(row<=monthDays){
					System.out.printf( " %3s " , grid[i][j]);
				}else{    
					System.out.printf( " %3s " , "_" );
				}            
			}
			count=count+ DAYS_IN_AWEEK; 
			System.out.println();
		}  
	}
	public static int daysInMonth(int month) {
		
		switch (month){
		case 4:
		case 6:
		case 9:
		case 11:
			return 30; // 30 days have September, April, June, and November
		case 2:
			return 28; // 28 days in February in a non-leap year
		default:
			return 31; // 31 days in all other months
		}			
	}
	public static void CreateCalenderHeader(String month,String year) {

		System.out.printf( "%15s\n" , month ); 

		for (int i=1;i<=35; i++){
			System.out.printf( "%1s" , "*");
		}  
		System.out.println();
		String[] myWeek={"Sun" ,"Mon" , "Tue" ,"Wed" ,"Thu" , "Fri" , "Sat"};  
		for(int i=0;i<myWeek.length;i++){
			System.out.printf(" %2s ",myWeek[i]);			
		}    
		System.out.println();    
	}		
	
	
	
}



