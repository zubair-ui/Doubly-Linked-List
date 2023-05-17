package doublyLinkedList;

public class DoublyLinkedList {
	
	Node head;
	Node tail;
	
	public void add(int val) {
		Node nNode = new Node();
		nNode.value=val;
		nNode.next=null;
		nNode.prev=null;
		
		if(head==null) {
			head=nNode;
			tail=nNode;
		}
		else {
			tail.next=nNode;
			nNode.prev=tail;
			tail=nNode;
			tail.next=null;
		}
	}
	
	public void remove(int val) {
		Node tNode = head;
		Node pNode = head;
		if (head.value == val) {
			head = head.next;
			head.prev=null;
		} else {
			while (tNode.next != null) {
				if (tNode.value == val) {
					pNode.next = tNode.next;
					tNode.next.prev=tNode.prev;
					break;
				}
				pNode = tNode;
				tNode = tNode.next;
			}
		}
	}
	
	public void removeAll() {
		head=null;
		tail=null;
	}
	
	public boolean contains(int val) {
		Node tNode = head;
		while (tNode!= null) {
			if (tNode.value == val) {
				return true;
			}
			tNode = tNode.next;
		}
		return false;
	}
	
	public void displayHeadToTail() {
		System.out.println("Values from Head to Tail are:");
		if(head==null) {
			System.out.println("No Values are present");
		}
		else {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.value + "\t");
			tNode = tNode.next;
		}
		System.out.println();
		}
	}
	
	public void displayTailToHead() {
		System.out.println("Values from Tail to Head are:");
		if(head==null) {
			System.out.println("No Values are present");
		}
		else {
		Node tNode = tail;
		while (tNode != null) {
			System.out.print(tNode.value + "\t");
			tNode = tNode.prev;
		}
		System.out.println();
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList obj = new DoublyLinkedList();
		
		obj.add(5);
		obj.add(8);
		obj.add(6);
		obj.add(12);
		System.out.println(">>>>>Add and Display Methods<<<<<");
		obj.displayHeadToTail();
		obj.displayTailToHead();
		
		System.out.println("\n>>>>>Contains Method<<<<<");
		System.out.println(obj.contains(6));
		
		System.out.println("\n>>>>>Remove Method<<<<<");
		obj.remove(8);
		obj.displayHeadToTail();
		obj.displayTailToHead();
		
		System.out.println("\n>>>>>Remove All Method<<<<<");
		obj.removeAll();
		obj.displayHeadToTail();
		obj.displayTailToHead();
	}

}
