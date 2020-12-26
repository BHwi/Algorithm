import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static final int MAX = 2000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[MAX];
		
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		for (int i = 0; i < MAX; i++) {
			if (arr[i])
				sb.append((i - 1000000) + "\n");
		}

		System.out.print(sb);

	}

}
