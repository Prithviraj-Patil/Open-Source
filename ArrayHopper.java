import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayHopper {

	private static int Maximum(int FirstInteger, int SecondInteger) {
		return Math.max(FirstInteger, SecondInteger);
	}

	@SuppressWarnings("resource")
	private static ArrayList<Integer> NumberExtractor() {

		ArrayList<Integer> numberList = new ArrayList<Integer>();

		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter number of elements in Array:");
			int noOfSubPattern = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter numbers (one on each line):");
			for (int i = 0; i < noOfSubPattern; i++)
				numberList.add(Integer.parseInt(scan.nextLine()));

			return numberList;

		} catch (Exception E) {
			System.out.println("Error while Extracting numbers from comsole.");
		}
		return null;
	}

	public static ArrayList<Integer> FindOptimumHopPath(
			ArrayList<Integer> InputArray) {

		try {

			int inputarrayIndex = 0, inputArraySize = 0;
			if (InputArray != null) {
				inputArraySize = InputArray.size();
			} else {
				return null;
			}

			ArrayList<Integer> optimumHopPath = new ArrayList<Integer>();
			int previousHopDistance = 0, potentialHopDistance = 0, currentHopDistance = 0, hopPosition = 0;

			if (InputArray.get(0) == 0 || inputArraySize == 0) {
				return null;
			}

			while (inputarrayIndex < inputArraySize
					&& inputarrayIndex <= currentHopDistance) {

				if (inputarrayIndex > previousHopDistance) {
					optimumHopPath.add(hopPosition);
					previousHopDistance = currentHopDistance;
				}

				potentialHopDistance = inputarrayIndex
						+ InputArray.get(inputarrayIndex);

				if (potentialHopDistance > currentHopDistance) {
					hopPosition = inputarrayIndex;
				}

				currentHopDistance = Maximum(currentHopDistance,
						potentialHopDistance);

				++inputarrayIndex;
			}

			if ((optimumHopPath.get(optimumHopPath.size() - 1) != hopPosition)
					&& (optimumHopPath.size() > 0)
					&& (inputarrayIndex > previousHopDistance)) {
				optimumHopPath.add(hopPosition);
			}

			if (previousHopDistance >= inputArraySize - 1) {
				return optimumHopPath;
			}

		} catch (Exception E) {
			System.out.println("Error while finding optimum hop path.");
		}
		return null;
	}

	public static void main(String[] args) {

		ArrayList<Integer> InputArrayList = NumberExtractor();
		ArrayList<Integer> OutputArrayList = null;

		if (InputArrayList != null && InputArrayList.size() > 0) {
			OutputArrayList = FindOptimumHopPath(InputArrayList);
		}
		if (OutputArrayList != null) {
			System.out.println("\nSolution:");

			for (int outputIterator = 0; outputIterator < OutputArrayList
					.size(); outputIterator++)
				System.out.print(OutputArrayList.get(outputIterator) + ", ");
			System.out.print("out");
		} else {
			System.out.println("failure \n");
		}

	}
}
