import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[50001];
		
		Arrays.fill(dp, 5);
		
		for(int i = 0; i < 224; i++) {
			dp[i * i] = 1;
		}
		
		for(int i = 1; i < 50000; i++) {
			if(i < 4) dp[i] = i;
			
			int root = (int) Math.sqrt(i);
			
			if(root * root == i) continue;
			
			for(int j = root; j > 0; j--) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		
		System.out.println(dp[n]);

	}

}
