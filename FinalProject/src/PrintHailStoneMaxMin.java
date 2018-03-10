
public class PrintHailStoneMaxMin {
	public static void main(String[] args) {
		
		printHailStone(2,3);
		
	}

	private static void printHailStone(int value, int length) {
		
		int min=value;
		int max=value;
		
		for (int i=1;i<=length-1;i++){
			if(value%2==0){
				value=value/2;
			}else{
				value=value*3+1;
			}
			if(value>max){
				max=value;
			}else if (value<min){
				min=value;
			}
		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}
}
