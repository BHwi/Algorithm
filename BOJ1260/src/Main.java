import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static int n, m, v, x, y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		int[][] arr = new int[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		int[] visited = new int[n + 1];
		dfs(arr, v, visited);
		bfs(arr);
		
		sc.close();
	}
	
	public static void bfs(int[][] arr) {
		System.out.println();
		
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int[] visited = new int[n + 1];
		
		queue.add(v);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			visited[tmp] = 1;
			System.out.print(tmp + " ");
			
			for (int i = 0; i < arr[tmp].length; i++) {
				if(arr[tmp][i] == 1 && visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	public static void dfs(int[][] arr, int v, int[] visited) {
		visited[v] = 1;
		
		System.out.print(v + " ");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + 1; j++) {
				if(arr[v][j] == 1 && visited[j] == 0) {
					visited[j] = 1;
					dfs(arr, j, visited);
				}
			}
		}
	}
}
