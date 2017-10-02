package prime.largeandsmallprimenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LargeSmallPrimeNumbers {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		LargeSmallPrimeNumbers lspn = new LargeSmallPrimeNumbers();
		lspn.printLargestAndSmallestPrime(lspn.getNumberList());
	}

	/*
	 * Get two fully validated and sorted numbers in an ArrayList
	 */
	public List<Integer> getNumberList() {
		List<Integer> inputNumbers = new ArrayList<Integer>();
		List<Integer> numberRange = new ArrayList<Integer>();
		boolean loopStatus = true;
		try {
			System.out.println("Please enter two numbers separated by a space :");
			while (loopStatus) {
				String[] numbers = this.readLine().split(" ");
				if (numbers.length == 2) {
					if (this.isGivenNumberValid(numbers[0]) && this.isGivenNumberValid(numbers[1])) {
						inputNumbers.add(Integer.parseInt(numbers[0].trim()));
						inputNumbers.add(Integer.parseInt(numbers[1].trim()));
						numberRange = this.getLargestAndSmallestNumbers(inputNumbers);
						loopStatus = false;
					} else {
						System.out.println("Please enter valid positive numbers greater than zero");
					}
				} else {
					System.out.println("Please enter two numbers separated by a space :");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				bufferedReader = null;
				isr.close();
				isr = null;
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		return numberRange;
	}

	/*
	 * Read a line from STDIN
	 */
	public String readLine() throws IOException {
		String inputNumber = "";
		inputNumber = bufferedReader.readLine();
		return inputNumber;
	}

	/*
	 * Print the largest and smallest prime numbers in given range of numbers
	 */
	public void printLargestAndSmallestPrime(List<Integer> numbersList) {
		boolean smallPrimeFound = false;
		boolean largePrimeFound = false;
		if (numbersList.get(0) == 1 || numbersList.get(0) == 2 || numbersList.get(0) == 3) {
			System.out.println("Smallest prime number is : " + numbersList.get(0));
			smallPrimeFound = true;
		}
		if (numbersList.get(1) == 1 || numbersList.get(1) == 2 || numbersList.get(1) == 3) {
			System.out.println("Largest prime number is : " + numbersList.get(1));
			largePrimeFound = true;
		}

		if (smallPrimeFound == false) {
			int smallNumber = numbersList.get(0);
			int largeNumber = numbersList.get(1);
			if (smallNumber % 2 == 0)
				smallNumber++;

			while (smallPrimeFound == false) {
				if (smallNumber <= largeNumber) {
					if (this.isGivenNumberPrime(smallNumber)) {
						System.out.println("Smallest prime number is : " + smallNumber);
						smallPrimeFound = true;
					} else {
						smallNumber += 2;
					}
				} else {
					System.out.println("No prime numbers found between " + numbersList.get(0) + " and "
							+ numbersList.get(1) + " numbers");
					System.exit(1);
				}
			}
		}

		if (largePrimeFound == false) {
			int smallNumber = numbersList.get(0);
			int largeNumber = numbersList.get(1);
			if (largeNumber % 2 == 0) {
				largeNumber--;
			}

			while (largePrimeFound == false) {
				if (largeNumber >= smallNumber) {
					if (this.isGivenNumberPrime(largeNumber)) {
						System.out.println("Largest prime number is : " + largeNumber);
						largePrimeFound = true;
					} else {
						largeNumber -= 2;
					}
				} else {
					// This part of code will never be executed.
					// Kept for code readability
					System.out.println("No prime numbers found between " + numbersList.get(0) + " and "
							+ numbersList.get(1) + " numbers");
					System.exit(1);
				}
			}
		}
	}

	/*
	 * Sort the given list of numbers
	 */
	public List<Integer> getLargestAndSmallestNumbers(List<Integer> numbers) {
		List<Integer> largeAndSmall = new ArrayList<Integer>();
		int small = numbers.get(0);
		int large = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++) {
			if (small > numbers.get(i))
				small = numbers.get(i);
			if (large < numbers.get(i))
				large = numbers.get(i);
		}
		largeAndSmall.add(small);
		largeAndSmall.add(large);
		return largeAndSmall;
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

	/*
	 * Check if the given number is prime or not. Returns true if number is
	 * prime. Else returns false
	 */
	public boolean isGivenNumberPrime(int integerNumber) {
		if (integerNumber == 1 || integerNumber == 2 || integerNumber == 3) {
			return true;
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
}
