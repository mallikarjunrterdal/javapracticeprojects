package logicalproblems.spiralmatrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralMatrix {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		spiralMatrix.printSpiralMatrix(spiralMatrix.readNumber());
	}

	public void printSpiralMatrix(int number) {
		int size = number * 2;

		for (int i = 1; i <= size - 1; i++) {
			if (i <= number) {
				for (int j = 1; j <= (i - 1); j++) {
					System.out.print(j + " ");
				}

				for (int j = i; j <= (size - (i - 1)) - 1; j++) {
					System.out.print(i + " ");
				}

				for (int j = (i - 1); j >= 1; j--) {
					System.out.print(j + " ");
				}
			} else {
				int pass = i - number;

				for (int j = 1; j <= (number - pass); j++) {
					System.out.print(j + " ");
				}

				for (int j = 1; j <= pass; j++) {
					System.out.print((number - pass) + " ");
				}

				for (int j = 1; j < pass; j++) {
					System.out.print((number - pass) + " ");
				}

				for (int j = (number - pass); j >= 1; j--) {
					System.out.print(j + " ");
				}
			}

			System.out.println();
		}
	}

	public int readNumber() {
		String inputNumber = "";
		boolean loopStatus = true;

		try {
			System.out.println("Please enter a number to print the spiral matrix : ");
			while (loopStatus) {
				inputNumber = bufferedReader.readLine();
				if (!this.isGivenNumberValid(inputNumber))
					System.out.println("Please enter a valid integer within 1-9 range : ");
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
		if (number.matches("^[1-9]$"))
			return true;
		else
			return false;
	}
}
