import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < N; i++) 
			ans ^= Integer.parseInt(st.nextToken());
		
		System.out.println(ans == 0 ? "cubelover" : "koosaga");
		
	}

}
