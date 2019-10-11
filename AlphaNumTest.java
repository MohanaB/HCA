import java.util.Scanner;
/*
 * This class is used to sort digits in a given string
 * If the string does not contain digits it throws an user defined exception
 * author:MO354826(Mohana Boddu)
 */
public class AlphaNumTest {

	public static void main(String[] args) throws AlphaException {
		// to take input
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter alphanumeric String:");
		String input = s.next();
		//to store digits from string
		int[] values = new int[input.length()];
		int indexdigit = 0;
		if (input.matches("[a-zA-Z]+"))
			throw new AlphaException();
		else {
//to find the digits in string
			for (int stringpos = 0; stringpos < input.length(); stringpos++) {
				if (Character.isDigit(input.charAt(stringpos))) {
					values[indexdigit] = Character.getNumericValue(input.charAt(stringpos));
					indexdigit++;
				}
			}

//to sort the values of digits
				for (int startpos = 0; startpos < indexdigit; startpos++) {
				for (int nextpos = 0; nextpos < indexdigit; nextpos++) {
					if (values[startpos] < values[nextpos]) {
						values[startpos] = values[startpos] + values[nextpos];
						values[nextpos] = values[startpos] - values[nextpos];
						values[startpos] = values[startpos] - values[nextpos];
					}
				}

			}
//to replace the digits with sorted values
			char[] charinput = input.toCharArray();
			for (int stringpos = 0, index = 0; stringpos < input.length(); stringpos++) {
				if (Character.isDigit(input.charAt(stringpos))) {
					char newreplace = (char) (values[index] + '0');
					charinput[stringpos] = newreplace;
					index++;
				}
			}
			
			String output = new String(charinput);
			System.out.println(output);
		}

	}
}
