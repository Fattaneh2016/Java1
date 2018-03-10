import java.util.Scanner;


public class PreFinalPreperation {
	public static void main(String[] args) {
		System.out.println(rhyme("a","a"));
		int n = 91;
		int factor = 2;
		while (n % factor != 0) {
		factor++;
		}
		System.out.println("First factor is " + factor);
		
		System.out.println("\ta\tb\tc");
		System.out.println("\\\\");
		System.out.println("'");
		System.out.println("\"\"\"");
		System.out.println("C:\nin\the downward spiral");
		//   / \// \\/// \\\
		
		results(23.5);
		System.out.println("/ \\// \\\\/// \\\\\\");
		/*
		 * This program prints a
quote from the Gettysburg Address.
"Four score and seven years ago,
our 'fore fathers' brought forth on
this continent a new nation."
		 */
		
		System.out.println("This program prints a \n quote from the Gettysburg Address.\n \"Four score and seven years ago,");
		//get the four digits of a number and first digit 
		System.out.println(658236489 % 10);
		System.out.println(658236489 % 10000);		
		System.out.println(9 / 5);		
		System.out.println(695 % 20);		
		System.out.println(7 + 6 * 5);		
		System.out.println(7 * 6 + 5);		
		System.out.println(248 % 100 / 5);
		System.out.println(6 * 3 -9 / 4);		
		System.out.println((5 -7) * 4);
		System.out.println(6 + (18 % (17 -12)));
		
		// index 0123456789012345678901
		String book = "Building Java Programs";
		System.out.println(book.substring(9, 13));
		
		/*Scanner console = new Scanner(System.in);
		System.out.print("Type your name, playa: ");
		String name = console.nextLine();
		// split name into first/last name and initials
		String first = name.substring(0, name.indexOf(" "));
		String last = name.substring(name.indexOf(" ") + 1);
		last = last.toUpperCase();
		String fInitial = first.substring(0, 1);
		System.out.println("Your gangsta name is \"" + fInitial +
		". Diddy " + last + " " + first + "-izzle\"");
		
		*/
		char c='h';
		String s="h";
		System.out.println(c+1);
		System.out.println(c+c);
		System.out.println(s+s);
		
		Scanner console = new Scanner(System.in);
		
		String name = console.next();
		if (name.startsWith("Prof")) 
		{System.out.println("When are your office hours?");}
		else if (name.equalsIgnoreCase("STUART")) 
		{
			System.out.println("Let's talk about meta!");
			}
		
	}
		// Calculates total owed, assuming 8% tax and 15% tip
		public static void results(double subtotal) {
		double tax = subtotal * .08;
		double tip = subtotal * .15;
		double total = subtotal + tax + tip;
		// System.out.println("Subtotal: $" + subtotal);
		// System.out.println("Tax: $" + tax);
		// System.out.println("Tip: $" + tip);
		// System.out.println("Total: $" + total);
		System.out.printf("Subtotal: $%.2f\n", subtotal);
		System.out.printf("Tax: $%.2f\n", tax);
		System.out.printf("Tip: $%.2f\n", tip);
		System.out.printf("Total: $%.2f\n", total);
		}
		
		// Returns true if s1 and s2 end with the same two letters.
		public static boolean rhyme(String s1, String s2) {
		return s1.length() >= 2 && s2.length() >= 2 && s1.endsWith(s2.substring(s2.length() -2));
		
		}
	}


