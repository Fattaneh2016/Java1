import java.util.Arrays;


public class small {
	public static void main(String[] args) {
		System.out.println("Create array");
		String[][] grid=new String[5][4];
		createGrid(grid);
		System.out.println("create array with shift");
		//createGridFirstDat(grid,1);
		System.out.println("update array");
		updateGrid(grid,1);
		System.out.println("Search array");
		//String mySearch=SearchGrid(grid,0,0,"9");
		String mySearch=SearchGrid(grid,0,0,"88");
		
		System.out.println(mySearch);
	}
	private static void createGridFirstDat(String[][] grid ,int first) {
		for (int i=0 ;i<grid.length; i++){
			
			for (int j=0;j<grid[i].length; j++){
				
				if (first==1){
					
					System.out.print( " " + grid[i][j] );
				}else{
					grid[i][j]=grid[i][j]="1";
					System.out.print( " " + grid[i][j]);
				}
				
			}
			System.out.println();	
		}
		
	}
	public static String SearchGrid(String[][] grid , int month, int day,String event) {
		for(int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length; j++){
				if (grid[i][j].equals(event) )
				{					 
					return event;
				}
		}
		}
		return "Not found";
		
	}
	private static void updateGrid(String[][] grid,int first) {
		
		for(int i=0;i<grid.length;i++){
			for (int j=0;j<grid[i].length; j++){
				grid[0][2]="8";
				if (first==1){
					
					grid[0][1]=" ";
					grid[0][0]=" ";
				}
			System.out.print( " " + grid[i][j]);
		}
			System.out.println();	
		}
	}

	private static void createGrid(String[][] grid) {
		
		for (int i=0 ;i<grid.length; i++){			
			for (int j=0;j<grid[i].length; j++){
				grid[i][j]="1";
				System.out.print( " " + grid[i][j]);
			}
			System.out.println();	
		}
	}
	
	
}
