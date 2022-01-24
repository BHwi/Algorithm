import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static double stod(String s) {return Double.parseDouble(s);}
	public static HashMap<Integer, Long> map = new HashMap<>();
	public static int[] arr;
	public static int N, S;
	public static long answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		S = stoi(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		dfsleft(0, 0);
		dfsright(N / 2, 0);
		
		if(S == 0) answer--;
		System.out.println(answer);
	}
	
	public static void dfsleft(int i, int sum) {
		if(i == N / 2) {
			if(map.containsKey(sum)) {
				map.put(sum, map.get(sum) + 1);
			}
			else {
				map.put(sum, (long) 1);
			}
			return;
		}
		dfsleft(i + 1, sum);
		dfsleft(i + 1, sum + arr[i]);
	}
	
	public static void dfsright(int i, int sum) {
		if(i == N) {
			if(map.containsKey(S - sum)) {
				answer += map.get(S - sum);
			}
			return;
		}
		dfsright(i + 1, sum);
		dfsright(i + 1, sum + arr[i]);
	}
}
