package Amazon_Online_Assessment_2023;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class FindUniqueValue {

	public FindUniqueValue() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(5);
		list.add(6);

		System.out.println(FindUniqueValue(list));
	}

	public static int FindUniqueValue(List<Integer> experience) {
		int len = experience.size(); // declares an integer variable named `len` and assigns it the value of the size
										// of the `experience` vector

		if (experience == null || len < 2) // check if `experience` vector is null OR his size is smaller than 2, so
											// that, contain at most one element
			return 0; // in such a case, returns 0

		Collections.sort(experience); // sorts the `experience` vector in ascending order

		HashSet<Double> averages = new HashSet<>(); // creates a new HashSet object named `averages` that will store
													// unique double values represents the averages of each pair
		int left = 0, right = (len - 1); // initialize the variables `left` and `right` to represent the two indices
											// that will be used to traverse the `experience` vector

		// Iterate through the `experience` vector from both ends and compute the
		// average of pairs of elements
		while (left < right) {
			double average = (experience.get(left) + experience.get(right)) / 2.0; // Compute the average of the left
																					// and right elements
			averages.add(average); // Add the average to the set of unique averages
			left++; // Move the left index to the right
			right--; // Move the right index to the left
		}

		return averages.size(); // returns an integer value that represents the number of unique elements that
								// were added to the `averages` HashSet object
	}
}
