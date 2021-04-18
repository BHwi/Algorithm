import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, arr[]; 
	public static boolean visited[], dp[] = new boolean[20 * 100_000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[arr[i]] = true;
		}
		
		for(int i = 0; i < N; i++) {
			visited = new boolean[N];
			solve(i, visited, arr[i]);
		}
		
		for(int i = 1; i < dp.length; i++) {
			if(!dp[i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
		
	}
	
	public static void solve(int i, boolean[] visited, int value) {
		if(i == N - 1) {
			return;
		}
		else {
			visited[i] = true;
			for(int j = i + 1; j < N; j++) {
				if(!visited[j]) {
					dp[value + arr[j]] = true;
					visited[j] = true;
					solve(j, visited, value + arr[j]);
					visited[j] = false;
				}
				else {
					continue;
				}
			}
		}
	}

}
