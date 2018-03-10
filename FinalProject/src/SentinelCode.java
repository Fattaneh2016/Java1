import java.util.Random;
import java.util.Scanner;


public class SentinelCode {
	public static final int SENTINEL=-1;
	public static void main(String[] args) {
		//sentinel();
		random();
	}
	private static void random() {
		Random ran=new Random();
		//A random number between 23 and 30 inclusive?
		//int randomNumber=ran.nextInt(8)+23;
		//A random even number between 4 and 12 inclusive?
		int randomNumber=ran.nextInt(9)+4;
		System.out.println(randomNumber);
		
	}
	private static void sentinel() {
		Scanner console=new Scanner(System.in);
		int sum=0;
		
		System.out.print("Enter a number ( " + SENTINEL + "  to quit): ");
		int number=console.nextInt();
		while(number!=-1){
			sum=sum+number;
			System.out.print("Enter a number ( " + SENTINEL + "  to quit): ");
			number=console.nextInt();
		}
		System.out.println("The totoal is " + sum);
		
	}
}
