package amstrongnumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AmstrongNumber {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {

		AmstrongNumber amstrongNumber = new AmstrongNumber();
		System.out.println(amstrongNumber.isGivenNumberAmstrong(amstrongNumber.readNumber()));
	}

	public boolean isGivenNumberAmstrong(int number) {
		List<Integer> numberList = this.convertNumbertoArray(number);
		long power = numberList.size();
		long sum = 0;
		long powerOfDigit = 0;

		for (int digit : numberList) {
			powerOfDigit = digit;
			for (int i = 1; i < power; i++) {
				powerOfDigit *= digit;
			}
			sum += powerOfDigit;
		}

		if (sum == number) {
			return true;
		}

		return false;
	}

	public List<Integer> convertNumbertoArray(int number) {
		List<Integer> numberList = new ArrayList<Integer>();
		while (number > 0) {
			numberList.add((number % 10));
			number /= 10;
		}
		return numberList;
	}

	public int readNumber() {
		System.out.println("Please enter a number to check if it is an Amstrong number or not : ");
		boolean loopStatus = true;
		String number = "";

		try {
			while (loopStatus) {
				number = bufferedReader.readLine();
				if (!this.isGivenNumberValid(number))
					System.out.println("Please enter a positive number to check if it is an Amstrong number or not : ");
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

	public boolean isGivenNumberValid(String number) {
		if (number.matches("^[0-9]+$"))
			return true;
		else
			return false;
	}

}
