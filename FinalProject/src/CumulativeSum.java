	
	import java.util.Scanner;

	public class CumulativeSum {
		public static void main(String[] args) {
			System.out.println("This program adds a sequence of :");
			System.out.println("numbers to find the average");
			System.out.println("and count how many are negative");
			System.out.println();
			Scanner console=new Scanner(System.in);
			System.out.print("How many numbers do you have?");
			int totalNumber=console.nextInt();
			
			double sum=0.0;
			int negatives=0;
			for (int i = 1; i <= totalNumber; i++) {
				System.out.print("   #" + i + "? ");			
			double next=console.nextInt();
			sum+=next;
			if(next<0){
				negatives++;
			}
			}
			System.out.println();	
			if (totalNumber<=0){
				System.out.println("No numbers to average");
			}else{
				double average=sum/totalNumber;
				System.out.println("average =" + average  );
			}
			System.out.println("# of negatives = " + negatives );
			System.out.println("Sum = " + sum);		
		}
	}

