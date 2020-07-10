package corecs.linkedlist.ds;

public class LinkedList {

	private Node head;

	public void add(int data) {

		Node newNode = new Node(data);

		if (this.head == null) {
			this.head = newNode;
			return;
		}

		Node tmpNode = this.head;

		this.head = newNode;
		this.head.setNext(tmpNode);
	}

	public void addAfterPos(int pos, int data) {

		
		if(this.head == null && pos != 0) {
			System.out.println("LinkedList is empty. Can not insert at pos -> " + pos);
			return;
		}

		if (this.head == null && pos == 0) {
			this.head = new Node(data);
			return;
		}
		
		int curPos = 0;
		Node curNode = this.head;
		
		while(curNode != null) {
			
			if(curPos == pos) {
				Node newNode = new Node(data);
				Node tmpNode = curNode.getNext();
				curNode.setNext(newNode);
				newNode.setNext(tmpNode);
				return;
			}
			curNode = curNode.getNext();
			curPos++;
		}
		
	}

	public void display() {

		if (this.head == null) {
			System.out.println("LinkedList is empty.");
			return;
		}

		Node curNode = this.head;

		while (curNode != null) {
			System.out.print(curNode.getData() + " -> ");
			curNode = curNode.getNext();
		}

		System.out.println(curNode);
	}

}
