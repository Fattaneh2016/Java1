
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] days=new String[31];
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};
		for(int i=0;i<myMonth.length; i++){
			//CreateCalender(2017,1,daysInMonth(i));
			
			for(int j=0;j<daysInMonth(i)-1;j++){
				System.out.print(myMonth[j]);
			}
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
	
	private static void CreateCalender(int year,int month, int j) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<31%7 ; i++){
			System.out.println(i);
	}
}
}
