import java.util.Scanner;

public class Main {
	
	public static int max = 0, n, k, min_w = 100001;
	public static int[] w, v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		w = new int[n];
		v = new int[n];
		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			min_w = Math.min(min_w, w[i]);
		}
		
		dp(visited, 0, 0, 0);
		
		System.out.println(max);
	}
	
	public static void dp(boolean[] visited, int weight, int value, int num) {
		if(weight + min_w > k)
			return;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && (weight + w[i]) <= k) {
				visited[i] = true;
				max = Math.max(max, value + v[i]);
				dp(visited, weight + w[i], value + v[i], num + 1);
				visited[i] = false;
			}
		}
	}

}
