public class Calendar {
	public static void main(String[] args) {
		printMonth(31, 6);
		printMonth(28, 1);
		printMonth(30, 2);
		printMonth(29, 4);
		printMonth(31, 7);
		
		
		
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
	
	public static void printMonth(int days, int firstSunday) {
		System.out.println("  Sun    Mon    Tue    Wed    Thu    Fri    Sat");
		System.out.println("+------+------+------+------+------+------+------+");
		
		int boxesPrinted = 0;
		if (firstSunday > 1) {
			System.out.print("|");
			int daysInFirstWeek = firstSunday - 1;
			for (int i = 1; i <= 7 - daysInFirstWeek; i++) {
				System.out.print("      |");
				boxesPrinted++;
			}
		}

		for (int currentDay = 1; currentDay <= days; currentDay++) {
			if (boxesPrinted % 7 == 0) {
				System.out.print("|");
			}
			
			System.out.print(padded(currentDay, 4) + "  |");
			boxesPrinted++;
			if (boxesPrinted % 7 == 0) {
				System.out.println();
			}
		}

		if (boxesPrinted % 7 != 0) {
			for (int i = boxesPrinted; i % 7 != 0; i++) {
				System.out.print("      |");
			}
			System.out.println();
		}
		
		System.out.println("+------+------+------+------+------+------+------+");
	}
	
	// Returns a string of the number n, left-padded
	// with spaces until it is at least the given width.
	public static String padded(int n, int width) {
		String s = "" + n;
		for (int i = s.length(); i < width; i++) {
			s = " " + s;
		}
		return s;
	}
}
