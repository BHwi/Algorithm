import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 100001;
	public static int N, S, dp[], min = INF;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			// put sum of array into dp[]
			if(i == 0) dp[i] = input;
			else dp[i] = dp[i - 1] + input;
		}
		
		for(int i = 0; i < N; i++) {
			/* Find value(= dp[i] - S) in range(0 ~ i - 1).
			 * with BinarySearch
			*/
			if(dp[i] < S) continue;
			
			int find = dp[i] - S;
			int index = Arrays.binarySearch(dp, find);
			
			if(index < 0) {
				index = -index - 1;
				
				if(index < N) {
					if(index == 0) {}
					if(dp[i] - dp[index] <= S) {
						index -= 1;
					}
				} else {
					index -= 1;
				}
			}
			
			min = Math.min(min, i - index);
		}
		
		System.out.println(min == INF ? 0 : min);
		
	}
}