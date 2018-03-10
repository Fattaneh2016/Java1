
public class GroupIdeas {

	public static void main(String[] args) {		
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};						
		int[][] temps=new int[6][7];		
		for(int i=0;i<myMonth.length;i++){				        
			CreateCalenderHeader(myMonth[i],"2017");
			System.out.println();
			CreateCalendar(temps ,daysInMonth(i+1));
			System.out.println();								
		}	
		System.out.println();		
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
					System.out.printf( " %2d " ,   0);
				}				
			}
			k=k+7;				
			System.out.println();
		}
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


