
public class DesignCalender {
	public static void  main(String [] args) {
		//createMonthTag("January");
		createMonthTable("January");
		//createTableYear("2017");
		
		
	}
		
		private static void createMonthTag(String string) {
			
			for(int i = 1; i <= 21; i++) {
				System.out.print("_");
			}
			System.out.println();
			System.out.printf("%15s" ,"Janaury");
					
			System.out.println();
			for(int i = 1; i <= 21; i++) {
				System.out.print("_");
			}
			System.out.println();
	}

		private static void createTableYear(String string) {
		
			
	}

		public static void createMonthTable(String string) {
		// TODO Auto-generated method stub
		for(	int i = 1; i <= 50; i++) {
			System.out.print("_");
		}				
		System.out.println( "January");
		System.out.println();
			System.out.printf("%5s  %5s %5s %5s  %5s %5s %5s", "Mon" , "Tue" ,"Wed" ,"Thu" , "Fri" , "Sat","Sun");
			System.out.println();
			
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 7; j++) {
				System.out.printf("|");
				System.out.printf("%4d", i*j);
				
			}
			System.out.println();	
			
		}
	}

		
	}

