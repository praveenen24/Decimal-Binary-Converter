
public class ConvertToDecimal {

	public static int getDecimal(String binary) {
		char[] c = binary.toCharArray();
		int factor = 1;
		int decimal = 0;
		for (int i = c.length - 1; i >= 0; i--) {
			if (c[i] != '1' && c[i] != '0') return -1;
			int bitValue = Character.getNumericValue(c[i]);
			decimal = decimal + (factor * bitValue);
			factor = factor * 2;
		}
		return decimal;
	}
}
