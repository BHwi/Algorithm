import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int m, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		int[][] arr = new int[n][m];
		int[][] visited = new int[n][m];
		int[][] count = new int[n][m];
		Deque<object> queue = new ArrayDeque<object>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					queue.add(new object(i, j));
					visited[i][j] = 1;
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!queue.isEmpty()) {
			object tmp = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == 0 && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					count[nx][ny] = count[tmp.x][tmp.y] + 1;
					queue.add(new object(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
		
		System.out.println(answer(arr, count));

	}
	
	public static class object{
		int x, y;
		
		object(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int answer(int[][] arr, int[][] count) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] == 0)
					return -1;
			}
		}
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				max = Math.max(max, count[i][j]);
			}
		}
		
		return max;
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
