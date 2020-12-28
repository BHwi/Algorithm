import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String str;
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			
			if(str.equals("top")) {
				if(!st.isEmpty()) sb.append(st.peek() + "\n");
				else sb.append(-1 + "\n");
			}
			else if(str.equals("pop")) {
				if(!st.isEmpty()) sb.append(st.pop() + "\n");
				else sb.append(-1 + "\n");
			}
			else if(str.equals("size")) {
				sb.append(st.size() + "\n");
			}
			else if(str.equals("empty")) {
				if(st.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else {
				String[] line = str.split(" ");
				st.push(Integer.parseInt(line[1]));
			}
		}
		
		System.out.print(sb);
	}

}
