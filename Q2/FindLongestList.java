package Amazon_Online_Assessment_2023;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindLongestList {

	public static void main(String[] args) {
		SinglyLinkedListNode head = new SinglyLinkedListNode(2);
		int[] arr = { 2, 10, 9, 8, 7, 6, 5, 4, 4, 3, 6, 7, 6, 5, 4, 3, 2 };

		SinglyLinkedListNode temp = head;
		for (int i = 0; i < arr.length; i++) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(arr[i]);
			temp.next = node;
			temp = temp.next;
		}
		SinglyLinkedListNode newNode = FindLongestNode(head);

		SinglyLinkedListNode current = newNode;
		System.out.print(current.data);
		current = current.next;
		while (current != null) {
			System.out.print("->" + current.data);
			current = current.next;

		}

	}

	/**
	 * [ImprovedFindLongestNode()] Space Complexity: O(n) Time Complexity: O(n)
	 * 
	 * where [n] is the length of the list
	 * 
	 * @param head
	 * @return
	 */
	public static SinglyLinkedListNode ImprovedFindLongestNode(SinglyLinkedListNode head) {
		if (head == null) // check if the head of the linked-list is empty
			return null; // in such a case, it returns null since no nodes exists

		SinglyLinkedListNode current = head; // creating a new reference to the head of the linked-list that can be
												// updated as we traverse the linked-list
		SinglyLinkedListNode result = new SinglyLinkedListNode(Integer.MIN_VALUE); // creating a new linked-list that
																					// will store the longest
																					// non-increasing subsequence of
																					// nodes

		List<Integer> nodeToList = new ArrayList<>(), maxSubsequence = new ArrayList<>(),
				currSubsequence = new ArrayList<>(); // creating three new ArrayLists to store the nodes of the
														// linked-list, as well as the maximum and current
														// non-increasing subsequences

		// common idiom for traversing a linked-list and performing some operation on
		// each node

		// iterates over the nodes of a linked-list `head`, extracts the `data` value of
		// each node, and adds it to an ArrayList `nodeToList`
		// convert the linked-list into an ArrayList representation. By doing so, we can
		// easily access each node's data value in constant time and iterate over them
		// using a simple for-loop

		while (current != null) {
			nodeToList.add(current.data);
			current = current.next;
		}

		currSubsequence.add(nodeToList.get(0)); // adds the first element of `nodeToList` to the `currentSubseqeunce`
												// ArrayList

		int i = 1; // initialize an iterator variable to execute while-loops

		/*
		 * This code block is an algorithm that finds the longest non-increasing
		 * subsequence of nodes in a linked-list. the algorithm iterates over the nodes
		 * in the linked-list by `nodeToList` ArrayList , check if each node's `data`
		 * value is greater than or equal to the previous node `data` value, and updates
		 * `currSubseqeunce` and `maxSubseqeunce` as necessary to find the longest
		 * non-increasing subsequence
		 */
		do {
			int x = nodeToList.get(i), k = nodeToList.get(i - 1);
			if (x <= k) // check if node's `data` value is smaller than or equal to the previous node's
						// `data` value
				currSubsequence.add(x); // in such a case, add the current node's `data` value to to `currSubsequence`
										// ArrayList
			else { // otherwise, if node's `data` value is greater than the previous node's `data`
					// value.
					// that is, the series is no longer a non-increasing series
				if (currSubsequence.size() > maxSubsequence.size()) // check if current subsequence size is greater than
																	// max subsequence size
					maxSubsequence = currSubsequence; // in such a case, update the max subsequence to be the current
														// subsequence
				currSubsequence = new ArrayList<>(); // assigning a new ArrayList to `currSubsequence` so that
														// `currSubseqeuence` is empty at the start of each
														// non-increasing subsequence
				currSubsequence.add(x); // add the current node's `data` value to the `currSubseqeuence`
			}
			i++; // increment the value of the variable `i` by 1 on each iteration of the loop
		} while (i < nodeToList.size());

		if (currSubsequence.size() > maxSubsequence.size()) // check if current subsequence size is greater than max
															// subsequence size
			maxSubsequence = currSubsequence;// in such a case, update the max subsequence to be the current subsequence

		current = result; // assigning a new reference to to head of the result's linked-list that can be
							// updated as we traverse the linked-list
		i = 0; // set the iterator variable to '0' as required to-do for execute the do-while
				// loop below

		/*
		 * This code block creates a new linked-list that contains the longest
		 * non-increasing subsequence of nodes, as determined by `maxSubsequence`
		 * ArrayList. the algorithm uses a while loop to iterate over each element of
		 * the `maxSubsequence` ArrayList, which contains the `data` values of the nodes
		 * in the longest non-increasing subsequence. on each iteration of the loop, the
		 * code creates a new node using the current `data` value from `maxSubsequence`,
		 * and sets the `next` pointer of the current node to point to the new node.
		 * Finally, the code updates `current` pointer to point to the next node.
		 */
		do {
			SinglyLinkedListNode node = new SinglyLinkedListNode(maxSubsequence.get(i++)); // creating a new node that
																							// holds the `data` value of
																							// the appropriate node from
																							// the `maxSubseqeunce`
																							// ArrayList.
			current.next = node; // sets the `next` pointer of the current node to point to the new node
			current = current.next; // updates `current` pointer to point to the next node
		} while (i < maxSubsequence.size());

		return result.next; // returns `result.next`, which is the longest non-increasing subsequence,
							// starting from the second node since the first node is the Integer.MIN_VALUE
							// node that was assigned at initialization

	}

	public static SinglyLinkedListNode FindLongestNode(SinglyLinkedListNode head) {
		if (head == null)
			return null;

		SinglyLinkedListNode current = head;
		SinglyLinkedListNode result = new SinglyLinkedListNode(Integer.MIN_VALUE);

		List<Integer> nodeToList = new ArrayList<>(), maxSubsequence = new ArrayList<>(),
				currSubsequence = new ArrayList<>();

		while (current != null) {
			nodeToList.add(current.data);
			current = current.next;
		}

		currSubsequence.add(nodeToList.get(0));

		int i = 1;

		do {
			int x = nodeToList.get(i), k = nodeToList.get(i - 1);
			if (x <= k)
				currSubsequence.add(x);
			else {
				if (currSubsequence.size() > maxSubsequence.size())
					maxSubsequence = currSubsequence;
				currSubsequence = new ArrayList<>();
				currSubsequence.add(x);
			}
			i++;
		} while (i < nodeToList.size());

		if (currSubsequence.size() > maxSubsequence.size())
			maxSubsequence = currSubsequence;

		current = result;
		i = 0;

		do {
			SinglyLinkedListNode node = new SinglyLinkedListNode(maxSubsequence.get(i++));

			current.next = node;
			current = current.next;
		} while (i < maxSubsequence.size());

		return result.next;
	}
}
