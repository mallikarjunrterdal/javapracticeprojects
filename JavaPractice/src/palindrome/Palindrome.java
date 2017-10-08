package palindrome;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Palindrome {

	public InputStreamReader isr = new InputStreamReader(System.in);
	public BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		Palindrome palindrome = new Palindrome();
		if (palindrome.isGivenNumberPalindrome(palindrome.readNumber()))
			System.out.println("Given number is palindrome");
		else
			System.out.println("Given number is not palindrome");
	}

	public boolean isGivenNumberPalindrome(int number) {
		List<Integer> numberList = new ArrayList<Integer>();
		int halfSize = 0;

		while (number > 0) {
			numberList.add((number % 10));
			number /= 10;
		}

		halfSize = numberList.size() / 2;

		if (halfSize % 2 != 0)
			halfSize += 1;

		for (int i = 0; i < halfSize; i++) {
			if (numberList.get(i) != numberList.get((numberList.size() - 1 - i))) {
				return false;
			}
		}

		return true;
	}

	public int readNumber() {
		System.out.println("Please enter a number to check if it is a palindrome or not : ");
		boolean loopStatus = true;
		String number = "";

		try {
			while (loopStatus) {
				number = bufferedReader.readLine();
				if (!this.isGivenNumberValid(number))
					System.out.println("Please enter a positive number to check if it is a palindrome or not : ");
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
