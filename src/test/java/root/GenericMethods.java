package root;

import java.util.Random;

public class GenericMethods {
	
	public static int[] generateRandomNumbers() {
		   Random r = new Random();
		   int[] fiveRandomNumbers = r.ints(5, 0, 11).toArray();
		   return fiveRandomNumbers;
		   
	   }

}
