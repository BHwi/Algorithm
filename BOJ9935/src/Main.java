import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String str = br.readLine();
		String remove = br.readLine();
		
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
			
			if(st.size() >= remove.length()) {
				boolean b = true;
				for(int j = 0; j < remove.length(); j++) {
					if(st.get(st.size() - remove.length() + j) != remove.charAt(j)) {
						b = false;
						break;
					}
				}
				if(b) {
					for(int j = 0; j < remove.length(); j++) {
						st.pop();
					}
				}
			}
		}
		
		for(char ch : st) sb.append(ch);
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
	}

}
