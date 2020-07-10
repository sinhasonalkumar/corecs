package corecs.linkedlist.ds;

public class LinkedListMain {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(0);
		
		list.display();
		
		list.addAfterPos(3, 5);
		
		list.display();
	}
}
