package prime.primeornot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Program to find whether the given number is prime or not
 */

public class PrimeOrNot {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		PrimeOrNot primeOrNot = new PrimeOrNot();
		primeOrNot.primeWrapper();
	}

	/*
	 * Wrapper method to orchestrate the program flow
	 */
	public void primeWrapper() {
		String choice = "y";
		try {
			do {
				System.out.println("Please enter a number to check if it is prime or not :");
				String inputNumber = this.readLine();
				if (this.isGivenNumberValid(inputNumber)) {
					if (this.isGivenNumberPrime(Integer.parseInt(inputNumber))) {
						System.out.println(inputNumber + " is prime number");
					} else {
						System.out.println(inputNumber + " is not prime number");
					}
				} else {
					System.out.println("Please enter a valid positive integer");
					continue;
				}
				System.out.println("Do you wish to continue(y/n)?:");
				choice = this.readLine();
			} while (choice.equals("y") || choice.equals("Y"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				System.out.println("***Exitting the program***");
				bufferedReader.close();
				bufferedReader = null;
				isr.close();
				isr = null;
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	/*
	 * Gets the input from STDIN. Returns the input characters from STDIN
	 */
	public String readLine() throws IOException {
		String input = "";
		input = bufferedReader.readLine();
		return input;
	}

	/*
	 * Check if the given number is prime or not. Returns true if number is
	 * prime. Else returns false
	 */
	public boolean isGivenNumberPrime(int integerNumber) {
		if (integerNumber == 1 || integerNumber == 2 || integerNumber == 3) {
			return true;
		} else if (integerNumber % 2 == 0) {
			return false;
		} else {
			int squareRoot = this.getMaximumSquareRoot(integerNumber);
			for (int i = 2; i <= squareRoot; i++)
				if (integerNumber % i == 0)
					return false;
		}
		return true;
	}

	/*
	 * Finds the maximum square root of a number which is less than given
	 * integerNumber. For example, if the given number is 40, then this method
	 * will return 6 as 6 * 6 = 36 which is less than 40. It does not return 7
	 * as 7 * 7 = 49 which is greater than 40.
	 */
	public int getMaximumSquareRoot(int integerNumber) {
		if (integerNumber == 1 || integerNumber == 2)
			return integerNumber;

		for (int i = 2;;)
			if (((i + 1) * (i + 1)) > integerNumber)
				return i;
			else
				i++;
	}

	/*
	 * Checks if the given number is positive integer or not. Positive integers
	 * includes all numbers starting from 1.
	 */
	public boolean isGivenNumberValid(String inputNumber) {
		if (inputNumber.matches("^[^0+\\-+]\\d*$"))
			return true;
		else
			return false;
	}
}
