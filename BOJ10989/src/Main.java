import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()), i, j;
		int[] dp = new int[10001];
		
		for(i = 0; i < n; i++)
			dp[Integer.parseInt(br.readLine())]++;
		
		for(i = 0; i < 10001; i++) {
			for(j = 0; j < dp[i]; j++)
				sb.append(i + "\n");
		}
		
		System.out.print(sb);
 
	}

}
