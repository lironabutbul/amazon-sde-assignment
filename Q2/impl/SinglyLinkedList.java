package Amazon_Online_Assessment_2023;

public class SinglyLinkedList {
	
	public SinglyLinkedListNode head;
	public SinglyLinkedListNode tail;
	
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void insertNode(int nodeData) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
		
		if(this.head == null) {
			this.head = node;
		} else {
			this.tail.next = node;
		}
		
		this.tail = node;
	}

}
