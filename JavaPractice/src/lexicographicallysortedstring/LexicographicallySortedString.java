package lexicographicallysortedstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LexicographicallySortedString {

	public static void main(String args[]) {

		LexicographicallySortedString sortedString = new LexicographicallySortedString();
		if (sortedString.isStringSortedLexicographically(sortedString.readString())) {
			System.out.println("String is lexicographically sorted");
		} else {
			System.out.println("String is not lexicographically sorted");
		}
	}

	public boolean isStringSortedLexicographically(String string) {
		int stringLength = string.length();

		for (int i = 0; i < stringLength - 1; i++) {
			if (string.charAt(i) > string.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public String readString() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(isr);
		System.out.println("Please enter a string to check if it is lexicographically sorted or not: ");

		try {
			return bufferedReader.readLine();
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
		return null;
	}
}
