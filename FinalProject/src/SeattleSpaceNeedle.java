
public class SeattleSpaceNeedle {

	public static void main(String[] args) {
		verticalLine();


	}

	public static void verticalLine() {
		for (int line=1;line<=4;line++){
			for (int i=1;i<=12;i++){
				System.out.print(" ");	
			}
			System.out.print("||");
			for (int i=1;i<=12;i++){
				System.out.print(" ");
			}
			System.out.println();
		}
		

	}

}
