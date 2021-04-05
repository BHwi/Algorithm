import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 1_000_001;
	public static int N;
	public static int[] arr = new int[INF], x = new int[INF], y = new int[INF];
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		solve();
		
		N = Integer.parseInt(br.readLine());
		
		while(N != 0) {
			boolean b = false;
			
			for(int i = 2; i <= N / 2; i++) {
				if(arr[i] == 0 && arr[N - i] == 0) {
					sb.append(N + " = " + i + " + " + (N - i) + "\n");
					b = true;
					break;
				}
			}
			
			if(!b) {
				sb.append("Goldbach's conjecture is wrong.");
			}
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb.toString());
	}
	
	public static void solve() {
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] != 0) continue;
			else {
				if(i != 2) list.add(i);
				for(int j = 2; j * i < arr.length; j++) {
					arr[i * j] = 1;
				}
			}
		}
	}

}
