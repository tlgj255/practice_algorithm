package algorithm;

import java.util.Stack;

public class fir extends Stack{
	private static Stack numStack = new Stack();
	private static Stack notNumStack = new Stack();
	private static Integer result;
	public static void mult(Integer a,Integer b) {
		System.out.println(a+" "+b);
		result = a*b;
		npush(result);
	}public static void plus(Integer a,Integer b) {
		System.out.println(a+" "+b);
		result = a+b;
		npush(result);
	}public static void mns(Integer a,Integer b) {
		System.out.println(a+" "+b);
		result = b-a;
		npush(result);
	}public static void div(Integer a,Integer b) {
		System.out.println(a+" "+b);
		result = b/a;
		npush(result);
	}
	public static void npush(int push) {
		numStack.push(push);
	}
	public static Integer nPop() {
		if(numStack.isEmpty())
			return null;
		return (int)numStack.pop();
	}
	public static void nNpush(Character push) {
		notNumStack.push(push);
	}
	public static char nNPop() {
 		if(notNumStack.isEmpty())
			return (Character) null;
		return (char)notNumStack.pop();
	}
public static void main(String[] args) {
	String a = "((19+(2*10))-15)";
	int i = 0,j = 0,bk = 0;
	char[] b = a.toCharArray();
	char getpush;
while(true) {
	if(i>=a.length())
		break;
	if((b[i] == '(' || bk > 0)&&b[i] != ')') {
		if(b[i] == '(')
		bk++;
		else if((int)b[i] < 58&&(int)b[i]>47) {
			j = j*10+((int)b[i]-48);
		}
		else if(j != 0){
			npush(j);
			j = 0;
		nNpush(b[i]);
		}else
			nNpush(b[i]);
		i++;
		continue;
	}
		else if(b[i] == ')') {
		if(j > 0){
			npush(j);
			j = 0;
		}
		bk --;
		getpush = nNPop();
		if(getpush == '+') {
		plus(nPop(),nPop());
		i++;
		continue;
		}
		else if(getpush == '-') {
		mns(nPop(),nPop());
		i++;
		continue;
		}
		else if(getpush == '*') {
		mult(nPop(),nPop());
		i++;
		continue;
		}
		else if(getpush == '/') {
		div(nPop(),nPop());
		i++;
		continue;
		}
	}
}
System.out.println(nPop());
}
}
