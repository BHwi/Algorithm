import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();

		int number = 1, i = 0;

		while (number <= n) {
			if (st.isEmpty()) {
				st.push(number);
				sb.append("+\n");
				number++;
			} else {
				while (!st.isEmpty() && st.peek() == arr[i]) {
					st.pop();
					sb.append("-\n");
					i++;
				}

				st.push(number);
				sb.append("+\n");
				number++;
			}
		}
		
		if(!st.isEmpty()) {
			while (!st.isEmpty() && st.peek() == arr[i]) {
				st.pop();
				sb.append("-\n");
				i++;
			}
		}

		if (st.isEmpty())
			System.out.print(sb);
		else
			System.out.println("NO");

	}

}
