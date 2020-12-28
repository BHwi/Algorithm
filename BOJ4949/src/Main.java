import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayList<String> list = new ArrayList<>();
		
		String str = br.readLine();
		
		while(!str.equals(".")) {
			list.add(str);
			str = br.readLine();
		}
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(isBalence(itr.next()));
		}
		
		
	}
	
	public static String isBalence(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				st.push('(');
			}
			else if(ch == ')') {
				if(st.size() == 0)
					return "no";
				else if(st.peek() == '(') 
					st.pop(); 
				else 
					return "no";
			}
			else if(ch == '[') {
				st.push('[');
			}
			else if(ch == ']') {
				if(st.size() == 0)
					return "no";
				else if(st.peek() == '[')
					st.pop();
				else 
					return "no";
			}
		}
		
		if(st.size() != 0)
			return "no";
		
		return "yes";
	}

}
