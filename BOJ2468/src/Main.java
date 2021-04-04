import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int N, MAX = 100, arr[][], ans = 0;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i <= MAX; i++) {
			ans = Math.max(ans, count(makeArr(i)));
		}
		
		System.out.println(ans);
		
	}
	
	public static int count(boolean[][] arr) {
		int count = 0;
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && arr[i][j]) {
					bfs(arr, i, j);
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void bfs(boolean[][] arr, int x, int y) {
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		q.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = curx + dx[i];
				int ny = cury + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(!visited[nx][ny] && arr[nx][ny]) {
						q.add(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static boolean[][] makeArr(int depth) {
		boolean[][] tmp = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] > depth)
					tmp[i][j] = true;
			}
		}
		
		return tmp;
	}

}
