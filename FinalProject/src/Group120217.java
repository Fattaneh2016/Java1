
//import Calendar class from java library to get date and time
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;
public class Group120217{
	public static final int DAYS_IN_AWEEK=7;  
	public static void main(String[] args) {
		//get  Instance of  a calendar class and show the current date and time
		Calendar cal = Calendar.getInstance();  
		System.out.println("Today is " + cal.getTime());
		//Draw line with star
		drawStar('*', 50);
		System.out.println();
		//Create an array for 12 months
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};
		//define two dimensional array for creating each month calendar  
		String[][] grid=new String[6][7];
		String[][] gridNew=new String[6][7];
		//Ask user for calendar year
		Scanner console=new Scanner(System.in);

		String updateMonth="";
		int day=0;
		int month=0;
		String description="";
		//ask user to input year , you can write any year and it will show the calendar for that year
		int year=AskUserForYear();
		//call creatCalendar method
		CreateCalender( grid, year,myMonth);		
		//Ask User For Event
		System.out.print("What month do you want to add an event from ( 1-12 )?");
		month = console.nextInt();

		int firstDayOfMonth=day(month,1,Integer.valueOf(year));
		CalendarMonth(gridNew,daysInMonth((month),year), firstDayOfMonth);		

		boolean option = true;    
		while(option) {

			System.out.print("What day do you want to add an event from ( 1- " + daysInMonth((month),year) + ")?");
			day = console.nextInt();

			System.out.print("Please enter the descirption the event will take place.");
			description=console.next();

			System.out.print("Please enter the hours the event will take place.");
			String timePlace = console.next();

			System.out.println("This event" + " " + " " + "has been scheduled on day" + " " + 
					day + " " + "of" + " " + myMonth[month-1] + "." );

			updateMonth=myMonth[month-1];
			System.out.println("Month : " + updateMonth);   
			System.out.println("Day : " + day);
			System.out.println("Time : " + timePlace);
			System.out.println("Description : " + description);
			System.out.println();

			//header for add event to calendar
			CreateCalenderHeader(updateMonth,year, true);
			System.out.println();
			//firstDayOfMonth is a method for finding the first day of each month                

			//Draw line with star
			drawStar('*', 120);
			firstDayOfMonth=day(month,1,Integer.valueOf(year));
			//add event to calendar and update the calendar																 			
			UpdateCalendarMonth(gridNew,daysInMonth((month),year), firstDayOfMonth,day,description,timePlace);
			//Draw line with star
			drawStar('*', 120);
			System.out.println();
			//ask user if wants to continue adding event to calendar or exit .
			System.out.print("Are there any other events that you wish to add?" + " " + "(Y/N)");
			String yesno = console.next();
			if(yesno.equalsIgnoreCase("N")) {
				option = false;
				//search continue until find the event 
				boolean optionSearch=true;
				while(optionSearch) {
					//Ask user to type the event note for searching the calendar by event note 
					System.out.print("Search calendar by event note:: " );
					String search = console.next();
					//show calendar 
					String mySearch=SearchCalendar(gridNew,month,day,search,description,timePlace);
					if (mySearch=="Not found"){ 
						optionSearch=true;
						System.out.println(" Your note event :: " + mySearch);     
					}else{
						optionSearch=false;
						System.out.println(" Your note event :: " + mySearch);
					}    
				}      
				System.out.println();     
			}
			else {	
				option = true;
				{
				}
			}			
		}
	} 
	public static int AskUserForYear() {
		Scanner console=new Scanner(System.in);
		System.out.print("Please enter a calender year? ");
		return console.nextInt();  
	}
	public static String SearchCalendar(String[][] grid , int month, int day,String search,String description,String timePlace) {
		for(int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length; j++){        			
				if ((grid[i][j].contains("*") && grid[i][j].contains(search)) ||  grid[i][j].contains(timePlace) )
				{           
					return description;
				}				
			}
		}
		return "Not found";
	} 
	public static void drawStar(char character , int count){
		for (int i=1;i<=count; i++){
			System.out.printf( "%1s" , character);
		} 
	}
	//create calendar year for each year
	public static void CreateCalendarYear(String[][] grid ,int monthDays ,int myFirstday) { 
		int count=0;  
		for (int i=0 ;i<grid.length; i++){      
			for (int j=0;j<grid[i].length; j++){          
				int row=j+count+1-myFirstday;
				String myRow=Integer.toString(row);
				if (row<=0){         
					grid[i][j]="-";
				}else{
					grid[i][j]=myRow;
				}                     
				if(row<=monthDays){
					System.out.printf( " %3s " , grid[i][j]);
				}else{
					System.out.printf( " %3s " , "-");
				}
			}
			count=count+ DAYS_IN_AWEEK; 
			System.out.println();
		}    
	} 		
	public static void UpdateCalendarMonth(String[][] gridNew,int monthDays ,int myFirstday,int day,String description ,String timePlace) { 
		int count=0;	
		System.out.println();
		for (int i=0 ;i<gridNew.length; i++){      
			for (int j=0;j<gridNew[i].length; j++){          
				int row=j+count+1-myFirstday;
				if(row<=monthDays){
					if( gridNew[i][j].equalsIgnoreCase(String.valueOf(day)) ){     
						gridNew[i][j]= day+ "*" + description + ":" + timePlace;
					}
					System.out.printf( " %13s " , gridNew[i][j]);		
				}else {
					System.out.printf( " %13s " , "-");
				}				
			}
			count=count+ DAYS_IN_AWEEK; 
			System.out.println();			
		} 		
		System.out.println();
	}  
	public static void CalendarMonth(String[][] gridUpdate,int monthDays ,int myFirstday) { 
		int count=0;				 
		for (int i=0 ;i<gridUpdate.length; i++){      
			for (int j=0;j<gridUpdate[i].length; j++){          
				int row=j+count+1-myFirstday;
				String myRow=Integer.toString(row);
				if (row<=0){         
					gridUpdate[i][j]="-";
				}else{
					gridUpdate[i][j]=myRow;
				}   

			}
			count=count+ DAYS_IN_AWEEK; 

		} 				
	}  
	public static void CreateCalender(String[][] grid ,int year,String[] myMonth) {
		System.out.printf( "You have selected calender year: %2s\n" , year );
		System.out.println();
		for(int i=0;i<myMonth.length;i++){ 
			//create calendar header for 12 month
			CreateCalenderHeader(myMonth[i],year,false );
			System.out.println();  
			int firstDayOfMonth=day(i+1,1,Integer.valueOf(year));    
			CreateCalendarYear( grid, daysInMonth((i+1),year), firstDayOfMonth);

			System.out.println();      
		}     
		System.out.println();
	} 
	//get the first day of each month by year
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
	//find the days in each month
	public static int daysInMonth(int month, int year) {
		switch (month){
		case 4:
		case 6:
		case 9:
		case 11:
			return 30; // 30 days have September, April, June, and November
		case 2:
			if (isLeapYear(year)){
				return 29;
			}
			else{
				return 28; // 28 days in February in a non-leap year
			}   
		default:
			return 31; // 31 days in all other months
		}   
	}
	//create calendar header includes months and days in two option when create the calendar and when the update 
	//is true create update calendar with new interface 
	public static void CreateCalenderHeader(String month,int year ,boolean update) {
		int nStar=0;
		if(update){
			nStar=120;
			System.out.printf( "%30s\n" , month ); 
		}else
		{
			nStar=35;
			System.out.printf( "%15s\n" , month ); 
		}
		for (int i=1;i<=nStar; i++){
			System.out.printf( "%1s" , "*");    
		}  
		System.out.println();
		String[] myWeek={"Sun" ,"Mon" , "Tue" ,"Wed" ,"Thu" , "Fri" , "Sat"};  
		for(int i=0;i<myWeek.length;i++){   
			if (update){
				System.out.printf(" %13s ",myWeek[i]); 
			}else
			{
				System.out.printf(" %2s ",myWeek[i]); 
			}     
		}    
		System.out.println();    
	}  
}





