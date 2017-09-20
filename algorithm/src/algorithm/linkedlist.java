package algorithm;

public class linkedlist{
private dnode head;
private int size = 0;
public dnode getHead() {
	return this.head;
}
public void addFirst(Object input) {
	dnode newNode = new dnode(input);
	newNode.setnext(head);
	head = newNode;
	size++;
}
dnode node (int index) {
	dnode x;
	x = head;
	for(int i = 0; i <= index; i++) {
		x = x.getnext();
	}
	return x;
}
public void add(int k,Object input) {
	if(k == 0)
		addFirst(input);
	else {
		dnode temp1 = node(k-1);
		dnode temp2 = temp1.getnext();
		dnode newNode = new dnode(input);
		temp1.setnext(newNode);
		newNode.setnext(temp2);
		size++;
	}
}
public String toString() {
	if(head == null)
		return "[]";
dnode temp = head;
String str = "[";
while(temp.getnext() != null) {
	str += temp.getdata() +".";
	
}
return null;
}
}
