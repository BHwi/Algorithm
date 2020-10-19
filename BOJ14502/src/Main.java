import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int n, m, max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int empty = 0, count = 0;
		int[][] arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 0) {
					empty++;
				}
			}
		}
		
		position[] empty_arr = new position[empty];
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(arr[i][j] == 0)
					empty_arr[count++] = new position(i, j);
		
		for(int i = 0; i < empty_arr.length; i++) {
			for(int j = 0; j < empty_arr.length; j++) {
				for(int k = 0; k < empty_arr.length; k++) {
					if(i != j && j != k && i != k) {
						position[] p = {empty_arr[i], empty_arr[j], empty_arr[k]};
						max = Math.max(max, bfs(arr, p));
					}
				}
			}
		}

		System.out.println(max);
		
		
	}
	
	public static class position {
		public int x, y;
		
		public position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int[][] arr, position[] p) {
		int[][] tmp = new int[n][m];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int count = 0;
		Deque<position> queue = new ArrayDeque<position>();
		
		arr_clone(arr, tmp);
		
		for(int i = 0; i < 3; i++)
			tmp[p[i].x][p[i].y] = 1;
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(tmp[i][j] == 2)
					queue.add(new position(i, j));
	
		while(!queue.isEmpty()) {
			int x = queue.peek().x;
			int y = queue.poll().y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					queue.add(new position(nx, ny));
				}
			}
		}
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < m; j++) 
				if(tmp[i][j] == 0) count++;
		
		return count;
	}
	
	public static void arr_clone(int[][] arr, int[][] tmp) {
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				tmp[i][j] = arr[i][j];
	}
}
