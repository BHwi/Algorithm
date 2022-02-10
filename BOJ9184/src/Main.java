import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static long[][][] dp = new long[51][51][51];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, solve(a, b, c));
		}
	}
	
	public static long solve(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		else if(a > 20 || b > 20 || c > 20) {
			return solve(20, 20, 20);
		}
		else if(a < b && b < c) {
			if(dp[a][b][c] == 0) 
				dp[a][b][c] = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c);
			return dp[a][b][c];	
		}
		else {
			if(dp[a][b][c] == 0) 
				dp[a][b][c] = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1);
			return dp[a][b][c];	
		}
	}
}
