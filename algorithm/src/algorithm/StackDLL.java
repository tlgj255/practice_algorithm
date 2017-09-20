package algorithm;

public class StackDLL {
private dnode top;
private DoubleLinkedList stack;
private int size = 0;
public StackDLL() {
	this.stack = new DoubleLinkedList();
}
public boolean empty() {
	return (top.getnext().equals(null));
}
public void push(Object item) {
	this.stack.addFirst(item);
	top = this.stack.getHead();
	size++;
}
public Object peek() {
	return this.stack.node(0);
}
public Object pop() {
	if(size > 0) {
		size --;
		return this.stack.removeFirst();
	}
	return null;
}
public static void main(String[] args) {
	StackDLL s = new StackDLL();
}
}
