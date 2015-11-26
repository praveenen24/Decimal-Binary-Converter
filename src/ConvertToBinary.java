import java.util.ArrayList;

public class ConvertToBinary {
	
	public static String getBinary(int decimal) {
		int remainder = 0;
		ArrayList<Integer> binary = new ArrayList<Integer>();
		while (decimal != 0) {
			remainder = decimal % 2;
			decimal = decimal / 2;
			if (remainder == 1) {
				binary.add(1);
			} else {
				binary.add(0);
			}
			
		}
		return getInt(reverse(binary));
	}
	
	private static String getInt(ArrayList<Integer> binary) {
		StringBuilder builder = new StringBuilder();
		for (Integer i : binary) {
			builder.append(i);
		}		
		return builder.toString();
	}

	private static ArrayList<Integer> reverse(ArrayList<Integer> binary) {
	    if(binary.size() > 1) {                   
	        int value = binary.remove(0);
	        reverse(binary);
	        binary.add(value);
	    }
	    return binary;
	}
}
