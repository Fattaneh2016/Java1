import java.util.Arrays;


public class ArrayOfTally {
	public static void main(String[] args) {
		int[] result=mostFrequentDigit(669260267);
		System.out.println(Arrays.toString(result));
	}

	private static int[] mostFrequentDigit(int n) {
		int[] counts = new int[10];
		while (n > 0) {
		// pluck off a digit and add to proper counter
		int digit = n % 10;
		System.out.println(digit);
		counts[digit]=counts[digit] +1;
		System.out.println(Arrays.toString(counts));
		n = n / 10;
		}
		return counts;
	}
	
}
