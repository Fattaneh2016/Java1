
import java.util.Calendar;
	import java.util.Scanner;
public class Vincent {
	
	
	 public static final int DAYS_IN_AWEEK=7; 
	 
	 public static void main(String[] args) {
	  //get  Instance of  a calendar class and show the current date and time
	  Calendar cal = Calendar.getInstance();  
	  System.out.println("Today is " + cal.getTime());
	 
	  System.out.println("**************************");
	  String[] myMonth={ "January" , "February","March","April" ,"May","June",
	    "July","August","September" ,"October","November","December"};
	  //define two dimensional array for creating each month calendar  
	  String[][] grid=new String[6][7]; // Changed to [6][7] to account for rows.
	  //Ask user for calendar year
	  Scanner console=new Scanner(System.in);
	  String updateMonth="";
	  int day=0;
	  int month=0;
	  
	  //ask user to input year
	  String year=AskUserForYear();
	  //call creatCalendar 
	  CreateCalender( grid, year,myMonth);
	  //Ask User For Event
	  boolean option = true;    
	  while(option) {
	   System.out.println("What month do you want to add an event?");
	   month = console.nextInt();
	   System.out.println("What day do you want to add an event?");
	   day = console.nextInt();
	   System.out.println("Please enter the descirption of the event you wish to schedule.");
	   String description=console.next();
	   System.out.println("Please enter the hours the event will take place.");
	   String timeplace = console.next();
	   System.out.println("This event" + " " + " " + "has been scheduled on day" + " " + 
	     day + " " + "of" + " " + myMonth[month-1] + "." );
	   updateMonth=myMonth[month-1];
	   System.out.println("Month :" + updateMonth);   
	   System.out.println("Day :" + day);
	   System.out.println("Time :" + timeplace);
	   System.out.println("Description :" + description);
	   System.out.println("                                          " + myMonth[month-1]);
	   //add event to calendar and update the calendar 
	   UpdateCalendar(grid ,daysInMonth(month+1),year,month ,day,description);
	   System.out.println();
	   //Ask user to type the event note for searching the calendar by event note 
	   System.out.println("Please enter description of event you want to search." );
	   String search = console.next();
	   //show calendar 
	   String mySearch=SearchCalendar(grid,month,day,search);
	   System.out.println(" Your event decription: " + description);
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
	 public static String SearchCalendar(String[][] grid , int month, int day,String description) {
	  for(int i=0;i<grid.length;i++){
	   for (int j=0;j<grid[i].length; j++){        
	    if (grid[i][j].contains("*") && grid[i][j].contains(description))
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
	    if(  grid[i][j].contains("32") || grid[i][j].contains("33") || grid[i][j].contains("34") || grid[i][j].contains("35") || grid[i][j].contains("36") || grid[i][j].contains("37") ||
	    	grid[i][j].contains("38")||grid[i][j].contains("39")|| grid[i][j].contains("-1")|| grid[i][j].contains("-2") || grid[i][j].contains("-3")|| grid[i][j].contains("-4")){     // couldn't put "0" because it would put dash on "30" and "10."
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
	   CreateCalendarYear( grid, daysInMonth(i+1) , SundayStart, (i+1));
	   System.out.println();       
	  } 
	  System.out.println();
	 } 
	 public static void CreateCalendarYear(String[][] grid ,int monthDays ,int mySunday, int month ) { 
	  int count=0;
	  switch(month){
	  case 9:
	  case 12:             // In September, and December day 1 starts on Friday at least for 2017, still needs to account for leap year. 
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count-4; 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	 } 
	  }
	  switch(month){
	  case 8:            // In August day 1 starts on Tuesday at least for 2017, still needs to account for leap year. 
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count-1; 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	 } 
	  }
	  switch(month){
	  case 6:            // In June day 1 starts on Thursday at least for 2017, still needs to account for leap year. 
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count-3; 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	 } 
	  }
	  switch(month){
	  case 5:            // In May day 1 starts on Monday at least for 2017, still needs to account for leap year. 
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count; 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	 } 
	  }
	  switch(month){
	  case 4:            // In April, July, day 1 starts on Saturday at least for 2017, still needs to account for leap year. 
	  case 7:
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count-5; 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	 } 
	  }
	  switch(month){
	  case 1:             // In January, October, day 1 starts on Sunday at least for 2017, still needs to account for leap year. 
	  case 10:
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count+1; // 
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
	  switch(month){
	  case 2:             // In February, March, November day 1 starts on Wednesday at least for 2017, still needs to account for leap year. 
	  case 3:
	  case 11:
		  for (int i=0 ;i<grid.length; i++){   
	   for (int j=0;j<grid[i].length; j++){
	    int row=j+count-2; // Added "-2" to shift the numbers to the right 
	    String myRow=Integer.toString(row);   
	    grid[i][j]=myRow;
	    if (mySunday==1){     
	     grid[0][0]="*";
	     grid[0][1]="*";
	    }
	    if(row<=monthDays&&row>=(monthDays-(monthDays-1))){  //Added "&&row>=(monthDays-(monthDays-1))" I used November as an example.
	     System.out.printf( " %3s " , grid[i][j]);
	    }else{    
	     System.out.printf( " %3s " , "_" );
	    }            
	   }
	   count=count+ DAYS_IN_AWEEK; 
	   System.out.println();
	  } 
	  
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
	  System.out.printf( "        %15s\n" , month ); 
	  for (int i=1;i<=39; i++){
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

