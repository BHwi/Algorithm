import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static char T[], P[];
	public static int ans = 0, pi[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		pi = new int[P.length];
		
		getPi();
		KMP();

		System.out.println(ans);
		System.out.println(sb.toString());

	}
	
	public static void getPi() {
		int j = 0;
		for(int i = 1; i < P.length; i++ ) {
			while(j > 0 && P[i] != P[j]) {
				j = pi[j - 1];
			}
			
			if(P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
	}
	
	public static void KMP() {
		int j = 0;
		
		for(int i = 0; i < T.length; i++) {
			while(j > 0 && T[i] != P[j]) {
				j = pi[j - 1];
			}
			
			if(T[i] == P[j]) {
				if(j == P.length - 1) {
					ans++;
					sb.append((i - P.length + 2) + " ");
					j = pi[j];
				}
				else {
					++j;
				}
			}
		}
	}

}
