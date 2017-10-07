package trailingzeros;

import factorial.FactorialIteratively;

public class TrailingZerosOfNFactorial {

	public static void main(String args[]) {
		FactorialIteratively factorial = new FactorialIteratively();
		TrailingZerosOfNFactorial trailingZeros = new TrailingZerosOfNFactorial();

		int number = factorial.readNumber();
		int countZeros = trailingZeros.getTrailingZeros(factorial.factorialIteratively(number));

		if (number < 40) {
			if (countZeros > 0) {
				System.out.println("number of trailing zeros are : " + countZeros);
			} else {
				System.out.println("No trailing zeros for factorial of " + number);
			}
		} else {
			System.out.println("Please enter number less than 39");
		}
	}

	public int getTrailingZeros(long factorialNumber) {
		int count = 0;
		while (factorialNumber > 0) {
			if (factorialNumber % 10 != 0) {
				break;
			} else {
				count++;
			}
			factorialNumber /= 10;
		}
		return count;
	}
}
