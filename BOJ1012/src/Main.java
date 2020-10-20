import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr;
		int test, i, j, k, x, y;
		int t = sc.nextInt();
		int[] answer = new int[t];
		
		for(test = 0; test < t; test++) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			
			arr = new int[n][m];
			
			for(i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				
				arr[y][x] = 1;
			}
			
			answer[test] = answer(arr); 
		}
		
		for(i = 0; i < answer.length; i++)
			System.out.println(answer[i]);

	}
	
	public static int answer(int[][] arr) {
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 1)
					count += bfs(arr, i, j);
			}
		}
		
		return count;
	}
	
	public static int bfs(int[][] arr, int i, int j) {
		Deque<object> queue = new ArrayDeque<object>();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		queue.add(new object(i, j));
		
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.poll().y;
			
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1) {
					arr[nx][ny] = 0;
					queue.add(new object(nx, ny));
				}
			}
		}
		
		return 1;
	}
	
	public static class object {
		int x, y;
		
		object(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
