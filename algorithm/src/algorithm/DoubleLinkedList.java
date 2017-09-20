package algorithm;

public class DoubleLinkedList {
private dnode head;
private dnode tail;
private int size = 0;
public dnode getHead() {
	return this.head;
}
public dnode getTail() {
	return this.tail;
}
public void addFirst(Object input) {
	dnode newNode = new dnode(input);
	newNode.setnext(head);
	if(newNode.getnext() == null)
		tail = newNode;
	else
		newNode.getnext().setPrev(newNode);
	head = newNode;
	size++;
}
public void addLast(Object input) {
	if(size == 0)
		addFirst(input);
	else {
		dnode newNode = new dnode(input);
		newNode.setPrev(tail);
		tail.setnext(newNode);
		tail = newNode;
	size++;
	}
}
dnode node (int index) {
	dnode x;
	if(index < size/2) {
		x = head;
		for (int i = 0; i <= index; i++) 
			x = x.getnext();
	}else {
	x = tail;
		for (int i = size; i > index; i--) 
				x = x.getPrev();
	}
			return x;
}
public void add(int k, Object input) {
	if(k == 0)
		addFirst(input);
	else {
		dnode temp1 = node(k-1);
		dnode temp2 = temp1.getnext();
		dnode newNode = new dnode(input);
		temp1.setnext(newNode);
		newNode.setPrev(temp1);
		newNode.setnext(temp2);
		if(newNode.getnext() == null)
			tail = newNode;
		else 
			temp2.setPrev(newNode);
		size++;
	}
}
public String toString() {
	if(head == null) {
		return "[]";
	}
	dnode temp = head;
	String str = "[";
	while(temp.getnext() != null) {
		str += temp.getdata() + ".";
		temp = temp.getnext();
	}
	str += temp.getdata();
	return str+"]";
}
public Object removeFirst() {
	dnode temp = head;
	head = temp.getnext();
	head.setPrev(temp.getPrev());
	Object returnData = temp.getdata();
	size--;
	return returnData;
}
public Object remove(int k) {
	if(k == 0)
		return removeFirst();
	dnode temp = node(k-1);
	dnode todoDeleted = temp.getnext();
	temp.setnext(temp.getnext().getnext());
	Object returnData = todoDeleted.getdata();
	if(todoDeleted == tail)
		tail = temp;
	todoDeleted = null;
	size--;
	return returnData;
}
public Object removeLast() {
	return remove(size-1);
}
public int size() {
	return size;
}
public Object get(int k) {
	dnode temp = node(k);
	return temp.getdata();
}
public int indexOfFront(Object data) {
	dnode temp = head;
	int index = 0;
	while(temp.getdata() != data) {
		temp = temp.getnext();
		index++;
		if(temp == null)
			return -1;
	}
	return index;
}
public int indexOfRear(Object data) {
	dnode temp = tail;
	int index = 0;
	while(temp.getdata() != data) {
		temp = temp.getPrev();
		index++;
		if(temp == null)
			return -1;
	}
	return index;
}
}