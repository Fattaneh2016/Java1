import java.util.Arrays;


public class testoneArray {
	public static void main(String[] args) {
		String[] myMonth={ "January" , "February","March","April" ,"May","June",
				"July","August","September" ,"October","November","December"};
		
		int[] myDays={28,30,31,30,29,30,30,31};
		
		for(int i=0;i<=11;i++){
			int m=myDays[i];
				for(int j=0;j<m ;j++)
				{
					//System.out.printf(" %2s ", j+1);
				}
				//System.out.println();
			}
		System.out.println(Arrays.binarySearch(myDays, 3));
		
	}
}
