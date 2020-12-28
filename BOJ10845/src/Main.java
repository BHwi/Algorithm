import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String str;
		Deque<Integer> st = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			str = br.readLine();
			
			if(str.equals("pop")) {
				if(!st.isEmpty()) sb.append(st.poll() + "\n");
				else sb.append(-1 + "\n");
			}
			else if(str.equals("size")) {
				sb.append(st.size() + "\n");
			}
			else if(str.equals("empty")) {
				if(st.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else if(str.equals("front")) {
				if(!st.isEmpty()) sb.append(st.peekFirst() + "\n");
				else sb.append(-1 + "\n");
			}
			else if(str.equals("back")) {
				if(!st.isEmpty()) sb.append(st.peekLast() + "\n");
				else sb.append(-1 + "\n");
			}
			else {
				String[] line = str.split(" ");
				st.add(Integer.parseInt(line[1]));
			}
		}
		
		System.out.print(sb);
	}

}
