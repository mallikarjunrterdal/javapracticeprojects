package pascalstriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PascalsTriangle {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		PascalsTriangle pascalTriangle = new PascalsTriangle();
		pascalTriangle.printPascalTriangle(pascalTriangle.readNumber());
	}

	public void printPascalTriangle(int number) {
		for (int i = 0; i < number; i++) {
			printLeftSpace((number - i));

			for (int j = 0; j <= i; j++)
				System.out.print((fact(i) / (fact(i - j) * fact(j))) + " ");

			System.out.println();
		}
	}

	public long fact(int number) {
		long fact = 1;
		if (number == 1)
			fact = 1;
		else
			for (int i = 1; i <= number; i++)
				fact = fact * i;

		return fact;
	}

	public void printLeftSpace(int length) {
		for (int i = 1; i < length; i++)
			System.out.print(" ");
	}

	public int readNumber() {
		String inputNumber = "";
		boolean loopStatus = true;

		try {
			System.out.println("Please enter a number to print the Pascal's triangle : ");
			while (loopStatus) {
				inputNumber = bufferedReader.readLine();
				if (!this.isGivenNumberValid(inputNumber))
					System.out.println("Please enter a valid integer : ");
				else
					loopStatus = false;
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
		return Integer.parseInt(inputNumber);
	}

	public boolean isGivenNumberValid(String number) {
		if (number.matches("^[1-9][0-9]*$"))
			return true;
		else
			return false;
	}
}
