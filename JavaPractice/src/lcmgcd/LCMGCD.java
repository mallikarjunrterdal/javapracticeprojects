package lcmgcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LCMGCD {

	public InputStreamReader isr = new InputStreamReader(System.in);
	public BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String[] args) {
		LCMGCD lcmgcd = new LCMGCD();
		// System.out.println(lcmgcd.isNumberValid("-0"));
		System.out.println(lcmgcd.getNumbers());
	}

	public List<Integer> getNumbers() {
		String[] numbers = null;
		List<Integer> numberList = new ArrayList<Integer>();
		boolean loopStatus = true;
		System.out.println("Please enter numbers separated by space");

		try {
			while (loopStatus) {
				numbers = readLine().split(" ");
				if (!this.isNumberArrayValid(numbers)) {
					System.out.println("Please enter valid integer numbers separated by space");
					continue;
				}
				loopStatus = false;
			}

			for (String number : numbers)
				numberList.add(Integer.parseInt(number));

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return numberList;
	}

	public void printLCM() {
		
	}

	public void printGCD() {

	}

	public boolean isNumberArrayValid(String[] numbers) {
		for (String number : numbers) {
			if (!number.matches("^([-\\d]|[\\d])\\d*"))
				return false;
		}
		return true;
	}

	public String readLine() throws IOException {
		String numbers = bufferedReader.readLine();
		return numbers;
	}
}
