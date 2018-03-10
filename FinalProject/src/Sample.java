import java.util.Arrays;


public class Sample {
	 public static void main(String[] args) {
		 String[] myArray={"1","2","3","4"};
		 
		 for(int i=0 ;i<myArray.length;i++){
			
			 System.out.print( " " + myArray[i]);
		 }
		
		
		String[] myArray2=Arrays.copyOf(myArray, 6);
		System.out.println();
		for(int i=0 ;i<myArray2.length;i++){
			
			if (myArray2[i]!=null){
				 System.out.print( " " +  myArray2[i]);
			}else {
				myArray2[i]="**";
				System.out.print( " " +  myArray2[i]);
			}
			
		 }
		
	 }
}
