package factorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialRecursively {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		FactorialRecursively factorial = new FactorialRecursively();
		int number = factorial.readNumber();
		if (number < 40) {
			System.out.println("Factorial of " + number + " is " + factorial.factorialRecursively(number));
		} else {
			System.out.println("Please enter number less than 39");
		}
	}

	public long factorialRecursively(int number) {
		if (number == 1)
			return 1;
		else
			return number * this.factorialRecursively(--number);
	}

	public int readNumber() {
		System.out.println("Please enter a number to get its factorial : ");
		boolean loopStatus = true;
		String number = "";

		try {
			while (loopStatus) {
				number = this.readLine();
				if (!this.isGivenNumberValid(number))
					System.out.println("Please enter a valid positive number to get its factorial : ");
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
		return Integer.parseInt(number);
	}

	public String readLine() throws IOException {
		String number = bufferedReader.readLine();
		return number;
	}

	public boolean isGivenNumberValid(String number) {
		if (number.matches("^[1-9][0-9]*$"))
			return true;
		else
			return false;
	}
}
