package Amazon_Online_Assessment_2023;

import java.io.BufferedWriter;
import java.io.IOException;

class SinglyLinkedListPrintHelper {
	
	public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}
	
}
