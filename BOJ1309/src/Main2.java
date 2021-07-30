import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main2 {
	public static final int INF = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		HashMap<String, Integer> m = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		long b = System.currentTimeMillis();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			sb = new StringBuilder();
			
			for(int j = 0; j < s.length(); j++) {
				sb.append(s.charAt(j));
				String tmp = sb.toString();
				
				if(m.containsKey(tmp)) {
					m.put(tmp, m.get(tmp) + 1);
				}
				else {
					m.put(tmp, 1);
				}
			}
		}
		
		String str = " " + br.readLine();
		
		long[] dp = new long[str.length()];
		dp[0] = 1;

		String[] sdp = new String[302];
		Arrays.fill(sdp, "");
		
		for(int i = 1; i < str.length(); i++) {
			for(int j = 1; j <= Math.min(i, 300); j++) {
				if(i > 300) {
					sdp[j] = sdp[j + 1] + str.charAt(i);
				}
				else {
					sdp[j] += str.charAt(i);
				}
				
				if(m.containsKey(sdp[j])) {
					dp[i] = (dp[i] + (dp[j - 1] * m.get(sdp[j]) % INF)) % INF;
				}
			}
		}
		
		System.out.println(dp[str.length() - 1]);
		
		long a = System.currentTimeMillis();
	}

}
