package algorithm;

public class dnode {
private dnode prev;
private Object data;
private dnode next;
public dnode(Object input) {
	this.prev = null;
	this.data = input;
	this.next = null;
}
public dnode getPrev() {
	return this.prev;
}
public void setPrev(dnode prev) {
	this.prev = prev;
}
public Object getdata() {
	return this.data;
}
public void setdata(Object data) {
	this.data = data;
}
public dnode getnext() {
	return this.next;
}
public void setnext(dnode next) {
	this.next = next;
}
public String toString() {
	return String.valueOf(this.data);
}
}
