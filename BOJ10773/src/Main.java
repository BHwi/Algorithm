import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			answer += tmp;
			if(tmp == 0) {
				answer -= st.pop();
			}
			else {
				st.push(tmp);
			}
		}
		
		System.out.println(answer);
		
	}

}
