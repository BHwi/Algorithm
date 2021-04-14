import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long N, M;
	public static long N_two, N_five, M_two, M_five, NM_two, NM_five;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		N_two = count(N, 2); N_five = count(N, 5);
		M_two = count(M, 2); M_five = count(M, 5);
		NM_two = count(N - M, 2); NM_five = count(N - M, 5);
		
		System.out.println(Math.min(N_two - M_two - NM_two, N_five - M_five - NM_five));
	}
	
	public static long count(long num, int divide) {
		long count = 0;
		
		for(long i = divide; i <= num; i *= divide) {
			count += (num / i);
		}
		
		return count;
	}

}
