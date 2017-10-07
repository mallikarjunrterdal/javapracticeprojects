package nonzerodigit;

import factorial.FactorialIteratively;

public class NonZeroDigitOfAFactorial {

	public static void main(String args[]) {
		FactorialIteratively factorial = new FactorialIteratively();
		NonZeroDigitOfAFactorial nonZeroDigit = new NonZeroDigitOfAFactorial();

		int number = factorial.readNumber();

		if (number < 40) {
			System.out.println("Last non-zero digit of factorial of " + number + " is "
					+ nonZeroDigit.getLastNonZeroDigit(factorial.factorialIteratively(number)));
		} else {
			System.out.println("Please enter number less than 39");
		}
	}

	public int getLastNonZeroDigit(long factorialNumber) {
		long digit = 0;
		while (factorialNumber > 0) {
			digit = factorialNumber % 10;
			if (digit != 0) {
				break;
			} else {
				factorialNumber /= 10;
			}
		}
		return (int) digit;
	}
}
