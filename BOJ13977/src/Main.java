import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static final long MOD = 1_000_000_007;
	public static long[] fac;

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static long pow(long x, long y) {
		long p = x;
		long ret = 1;

		while (y > 0) {
			if (y % 2 == 1)
				ret = (ret * p) % MOD;
			p = p * p % MOD;
			y /= 2;
		}

		return ret;
	}

	public static void solve(int N, int K) {
		if(K == 0 || N == K) {
			System.out.println(1);
			return;
		}
		// ret = N! * ((N - K)!)^-1 * (K!)^-1
		long ret = fac[N];
		
		ret = (ret * (pow(fac[N - K], MOD - 2))) % MOD;
		ret = (ret * (pow(fac[K], MOD - 2))) % MOD;
		
		System.out.println(ret);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M = stoi(br.readLine());
		fac = new long[4_000_001];

		for (int i = 1; i < fac.length; i++) {
			if (i == 1)
				fac[i] = 1;
			else
				fac[i] = (fac[i - 1] * i) % MOD;
		}

		while (M --> 0) {
			st = new StringTokenizer(br.readLine());

			solve(stoi(st.nextToken()), stoi(st.nextToken()));
		}
	}

}
