import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static int[] parent;
	
	// 경로압축 : O(log(n)), union by rank : O(log(n))
	// 둘 다 쓰면 : O(1)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int answer = 0;
		
		parent = new int[N];
		
		for (int i = 0; i < N; i++) parent[i] = i;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			if (!union(a, b)) {
				answer = i + 1;
				break;
			}
		}
		System.out.println(answer);
	}
	
	public static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		else {
			// 경로 압
			return parent[n] = find(parent[n]);
		}
	}
	
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a == b) {
			return false;
		}
		else {
			parent[a > b ? a : b] = a > b ? b : a;
			return true;
		}
	}
}
