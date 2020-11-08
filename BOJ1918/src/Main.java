import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String infix = sc.nextLine();
		
		toPostfix(infix);
	}
	
	public static void toPostfix(String str) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			char op;
			
			if(now == '(') 
			{
				stack.push(now);
			} 
			else if(isOperator(now)) 
			{
				while(!stack.isEmpty()) 
				{
					op = stack.peek();
					if(precedence(now) <= precedence(op)) 
					{
						System.out.print(op);
						stack.pop();
					} else break;
				}
				stack.push(now);
			} 
			else if(now == ')') 
			{
				printStack(stack, 1);
			} 
			else if('A' <= now && now <= 'Z') 
			{
				System.out.print(now);
			}
		}
		
		printStack(stack, 0);
	}
	
	public static boolean isOperator(char ch) {
		if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
			return true;
		
		return false;
	}
	
	public static void printStack(Stack<Character> stack, int mode) {
		char op;
		
		while(!stack.isEmpty()) {
			op = stack.pop();
			if(op == '(' && mode == 1) break;
			if(op == '(' && mode == 0) continue;
			System.out.print(op);
		}
	}
	
	public static int precedence(char op) {
		switch(op) {
			case '(': case ')': return 0;
			case '+': case '-': return 1;
			case '*': case '/': return 2;
		}
		return -1;
	}

}
