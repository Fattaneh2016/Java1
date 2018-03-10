import java.util.Arrays;
import java.util.Scanner;


public class Weather {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("How many days' temperatures? ");
		int days = console.nextInt();
		int[] temps = new int[days]; // array to store days' temperatures
		int sum = 0;
		for (int i = 0; i < days; i++) { // read/store each day's temperature
			System.out.print("Day " + (i + 1) + "'s high temp: ");
			temps[i] = console.nextInt();
			sum += temps[i];
		}
		double average = (double) sum / days;
		int count = 0; // see if each day is above average
		for (int i = 0; i < days; i++) {
			if (temps[i]> average) {
				count++;
			}
		}
		//int result=Arrays.binarySearch(temps, 12);
		//Arrays.fill(temps, 12);
		Arrays.copyOf(temps, 3);
		System.out.println(Arrays.toString(temps));
		// report results
		System.out.printf("Average temp = %.1f\n", average);
		System.out.println(count + " days above average");
	}
}