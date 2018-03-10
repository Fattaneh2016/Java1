
public class days {
	public static void main(String[] args) {
		
		// months[i] = name of month i
        String[] months = {
            "",                               // leave empty so that months[1] = "January"
            "January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
        };
        
       
		// int month = Integer.parseInt(args[0]);    // month (Jan = 1, Dec = 12)
	     //  int year = Integer.parseInt(args[1]); 
	       // year
		   
		 int[] myInts = new int[5];
		// int my = Integer.parseInt(args[0]);
		 
		// days[i] = number of days in month i
	        int[] days = {
	            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	        };
	        
		for (int i = 0; i < args.length; i++)
			days[i] = Integer.parseInt(args[i]);

		 System.out.println(days[1]);
	        
	       
	        
		System.out.println(days[0]);
	}
	
}
