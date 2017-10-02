package fibonacciseries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciSeriesRecurssively {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {

		FibonacciSeriesRecurssively fibonacciSeries = new FibonacciSeriesRecurssively();

		int number = fibonacciSeries.readNumber();
		if (number < 5849) {
			System.out.println("Fibonacci series of " + number + " is " + fibonacciSeries.fibonacciSeries(number));
		} else {
			System.out.println("Please enter number less than 5849");
		}
	}

	public long fibonacciSeries(int number) {
		if (number == 0 || number == 1)
			return number;
		else
			return (this.fibonacciSeries(number - 1) + this.fibonacciSeries(number - 2));
	}

	public int readNumber() {
		String inputNumber = "";
		boolean loopStatus = true;

		try {
			System.out.println("Please enter a number to find fibonacci series : ");
			while (loopStatus) {
				inputNumber = this.readLine();
				if (!this.isGivenNumberValid(inputNumber))
					System.out.println("Please enter a valid positive number to find fibonacci series : ");
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
		if (number.matches("^\\d+$"))
			return true;
		else
			return false;
	}

	public String readLine() throws IOException {
		return bufferedReader.readLine();
	}
}
