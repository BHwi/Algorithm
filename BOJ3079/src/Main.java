import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long  M, arr[], ans = 0, max = 0;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		System.out.println(solve(0, max * M) + 1);
	}
	
	public static long solve(long s, long e) {
		if(s > e) {
			return e;
		}
		
		long v = (s + e) / 2;
		
		if(count(v) < M) {
			return solve(v + 1, e);
		}
		else {
			return solve(s, v - 1);
		}
	}
	
	public static long count(long v) {
		long count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			count += v / arr[i];
		}
		
		return count;
	}

}
