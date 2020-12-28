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
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(br.readLine());
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
			else if (ch == ')'){
				if(st.size() == 0)
					return "NO";
				else if(st.peek() == '(')
					st.pop();
				else 
					return "NO";
			}
		}
		
		if(st.size() != 0)
			return "NO";
		
		return "YES";
	}

}
