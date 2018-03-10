
public class CharVersusInt {

	public static void main(String[] args) {
		
		Alphabet();
		System.out.println();
		Reverse("Ameri");

	}

	private static void Reverse(String phrase) {
		String result="";
		for(int i=0 ;i<phrase.length();i++){
			result=phrase.charAt(i) +result;
		}
		System.out.println(result);
	}

	private static void Alphabet() {
		for(char letter='a' ;letter<='z'; letter++){
			System.out.print( letter + " ");
		}
		
	}

}
