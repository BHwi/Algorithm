import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int n, m;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) == '1' ? 1 : 0;
			}
		}
		
		bfs(arr);
	}
	
	public static void bfs(int[][] arr) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		int[][] visited = new int[n][m];
		int[][] distance = new int[n][m];
		int[] start = {0, 0};
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		distance[0][0] = 1;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			visited[x][y] = 1;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(arr[nx][ny] == 1 && visited[nx][ny] == 0) {
						distance[nx][ny] = distance[x][y] + 1;
						visited[nx][ny] = 1;
						int[] putQueue = {nx, ny};
						queue.add(putQueue);
					}
				}
			}
		}
		
		System.out.println(distance[n - 1][m - 1]);
		
	}

}
