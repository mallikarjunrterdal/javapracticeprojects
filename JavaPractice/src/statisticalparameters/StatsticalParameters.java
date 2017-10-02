package statisticalparameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StatsticalParameters {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader bufferedReader = new BufferedReader(isr);

	public static void main(String args[]) {
		StatsticalParameters parameters = new StatsticalParameters();
		parameters.displayStasticalParameters(parameters.readNumbers());
	}

	public void displayStasticalParameters(List<Integer> listOfNumbers) {
		System.out.println("Mean of given class distribution is   : " + this.getMean(listOfNumbers));
		System.out.println("Median of given class distribution is : " + this.getMedian(this.sort(listOfNumbers)));

		List<Integer> mode = this.getMode(this.sort(listOfNumbers));
		if (mode != null) {
			System.out.println("Mode of given class distribution is   : " + mode);
		} else {
			System.out.println("Mode for the given class distribution does not exist");
		}
	}

	public int getMean(List<Integer> listOfNumbers) {
		int sum = 0;

		if (listOfNumbers.size() != 0) {
			for (int number : listOfNumbers)
				sum += number;
			return sum / listOfNumbers.size();
		}
		return 0;
	}

	public List<Integer> getMedian(List<Integer> listOfNumbers) {
		List<Integer> medianValues = new ArrayList<Integer>();
		int size = listOfNumbers.size();
		int halfSize = size / 2;
		if (size % 2 != 0) {
			medianValues.add(listOfNumbers.get(halfSize));
		} else {
			if (listOfNumbers.get(halfSize - 1) != listOfNumbers.get(halfSize)) {
				medianValues.add(listOfNumbers.get(halfSize - 1));
			}
			medianValues.add(listOfNumbers.get(halfSize));
		}
		return medianValues;
	}

	public List<Integer> getMode(List<Integer> listOfNumbers) {
		int count = 0;
		int mostFrequentCount = 0;
		int listSize = listOfNumbers.size();
		List<Integer> classInterval = new ArrayList<Integer>();

		for (int i = 0; i < listSize - 1; i++) {
			if (listOfNumbers.get(i) == listOfNumbers.get(i + 1)) {
				count++;
			} else {
				count = 0;
			}
			if (count > mostFrequentCount) {
				mostFrequentCount = count;
			}
		}

		if (mostFrequentCount <= 0) {
			return null;
		}
		count = 0;
		for (int i = 0; i < listSize - 1; i++) {
			if (listOfNumbers.get(i) == listOfNumbers.get(i + 1)) {
				count++;
			} else {
				count = 0;
			}
			if (count == mostFrequentCount) {
				classInterval.add(listOfNumbers.get(i));
			}
		}
		return classInterval;
	}

	public List<Integer> sort(List<Integer> listOfNumbers) {
		for (int i = 0; i < listOfNumbers.size(); i++) {
			for (int j = i + 1; j < listOfNumbers.size(); j++) {
				if (listOfNumbers.get(j) < listOfNumbers.get(i)) {
					int temp = listOfNumbers.get(i);
					listOfNumbers.set(i, listOfNumbers.get(j));
					listOfNumbers.set(j, temp);
				}
			}
		}
		return listOfNumbers;
	}

	public List<Integer> readNumbers() {
		String inputNumbers;
		List<String> listOfNumbers;
		boolean loopStatus = true;
		System.out.println("Please enter numbers separated to find the statistical parameters :");
		List<Integer> integerList = new ArrayList<Integer>();
		try {
			while (loopStatus) {
				inputNumbers = bufferedReader.readLine();
				listOfNumbers = Arrays.asList(inputNumbers.split(" "));
				if (!this.isGivenListValid(listOfNumbers)) {
					System.out.println("Please enter valid numbers separated by space :");
					continue;
				} else {
					loopStatus = false;
					for (String number : listOfNumbers)
						integerList.add(Integer.parseInt(number));
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
		return integerList;
	}

	public boolean isGivenListValid(List<String> listOfNumbers) {
		for (String number : listOfNumbers)
			if (!number.matches("^\\d+$"))
				return false;
		return true;
	}
}
