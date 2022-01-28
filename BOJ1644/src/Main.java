import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) { return Integer.parseInt(s);}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		
		boolean[] dp = new boolean[4000001];
		Arrays.fill(dp, true);
		
		for(int i = 0; i <= 4000000; i++) {
			if(i < 2) dp[i] = false;
			if(dp[i]) {
				for(int j = 2; j * i <= 4000000; j++) {
					dp[j * i] = false;
				}
			}
		}
		
		int a = 0;
		
		for(int i = 0; i < dp.length; i++) {
			if(dp[i]) a++;
		}
		
		System.out.println(a);
	}

}
