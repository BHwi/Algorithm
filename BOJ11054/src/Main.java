import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] i_arr, d_arr, i_dp, d_dp;
	public static int N, max = 0, max_index = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		i_arr = new int[N + 1];
		d_arr = new int[N + 1];
		i_dp = new int[N + 1];
		d_dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) 
			i_arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) 
			d_arr[i] = i_arr[N - i + 1];
		
		for(int i = 1; i <= N; i++) {
			if(i_dp[i] == 0) 
				i_dp[i] = 1;
			
			for(int j = 1; j < i; j++) {
				if(i_arr[i] > i_arr[j]) {
					i_dp[i] = Math.max(i_dp[j] + 1, i_dp[i]);
				}
			}
			
			if(d_dp[i] == 0)
				d_dp[i] = 1;
			
			for(int j = 1; j < i; j++) {
				if(d_arr[i] > d_arr[j]) {
					d_dp[i] = Math.max(d_dp[j] + 1, d_dp[i]);
				}
			}
		}
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			
		}
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, i_dp[i] + d_dp[N - i + 1]);
		}
		
		System.out.println(max - 1);

	}

}
