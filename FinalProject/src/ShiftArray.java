
public class ShiftArray {
	public static void main(String[] args) {
		shiftArrayToRight();
		ShiftTwoArrays();		
		}
	private static void ShiftTwoArrays() {
		int[][] arr =new int[5][7];	
		int count=0;
		for (int i = 0; i < arr.length; i++){	
			for (int j = 0; j < arr.length; j++){
				arr[i][j]=j+1;
				 System.out.print( " " + arr[i][j]);
				 count=count+7;
			}
			System.out.println();
		}				
		for (int i = 0; i < arr.length; i++){	
			System.out.println();
			int temp=arr[i][arr.length-1];	
			for(int j=arr.length-2;j>=0;j--){
				arr[i][j+1]=arr[i][j];
			}
			arr[i][0]=temp;
			System.out.println();
		}						
		for (int i = 0; i < arr.length; i++){
			for (int j= 0; j < arr.length; j++){
			 System.out.print( " " + arr[i][j]);
			 count=count+7;
		}
			System.out.println();
		}		
	}
	private static void shiftArrayToRight() {
		int[] arr ={2,9,8,4,7};		
		for (int i = 0; i < arr.length; i++){			
				 System.out.print( " " + arr[i]);
			}
		//rotate array 3 times
		for(int j=1;j<=2;j++){
			int temp=arr[arr.length-1];	
			//System.out.println(temp);
			System.out.println();
			for(int i=arr.length-2;i>=0;i--){
				arr[i+1]=arr[i];
			}
			arr[0]=temp;
		}				
		System.out.println();
		for (int i = 0; i < arr.length; i++){			
			 System.out.print( " " + arr[i]);
		}
		
		
	}
	
	
	}
