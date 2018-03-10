
public class MyArmStrong {	
	public static void main(String[] args) {
		checkArmstrong(153);
		checkArmstrong(53);
	}
	public static void checkArmstrong(int originalNumber){
		int remainder;
		int result=0;
		int number=originalNumber;
		while (number != 0)
	    {
	        remainder = number % 10;	        
	        result += Math.pow(remainder, 3);	        
	        number = number/10;	              
	    }				
	    if(result == originalNumber)
	    {
	    	System.out.println(originalNumber + " is an Armstrong number.");	    		    
	    }	else
	    {
	    	System.out.println(originalNumber + " is not an Armstrong number.");
	    	
	    }	    
	    }	 		
	}

