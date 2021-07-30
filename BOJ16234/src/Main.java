import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int x, y;
		
		Node(int x, int y) {this.x = x; this.y = y;};
	}
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, L, R, count = 0;
	public static boolean isEnd = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(!isEnd) {
			arr = move(arr);
		}
		
		System.out.println(count);
	}
	
	public static int[][] move(int[][] arr) {
		isEnd = true;
		int[][] returnArr = new int[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(returnArr[i], -1);
		boolean[][] visited = new boolean[N][N];
		ArrayDeque<Node> q;
		ArrayDeque<Node> move_q;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					
					q = new ArrayDeque<>();
					move_q = new ArrayDeque<>();
					int person = 0;
					
					q.add(new Node(i, j));
					move_q.add(new Node(i, j));
					
					while(!q.isEmpty()) {
						Node cur = q.poll();
						int x = cur.x;
						int y = cur.y;
						person += arr[x][y];
						
						for(int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							
							if(isBoundary(nx, ny) && !visited[nx][ny]) {
								int d = Math.abs(arr[x][y] - arr[nx][ny]);
								
								if(L <= d && d <= R) {
									q.add(new Node(nx, ny));
									move_q.add(new Node(nx, ny));
									visited[nx][ny] = true;
								}
							}
						}
					}
					
					if(move_q.size() != 1) {
						isEnd = false;
						
						int size = move_q.size();
						int p = person / size;
						
						while(!move_q.isEmpty()) {
							Node cur = move_q.poll();
							int x = cur.x;
							int y = cur.y;
							
							returnArr[x][y] = p;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(returnArr[i][j] == -1) {
					returnArr[i][j] = arr[i][j];
				}
			}
		}
		
		if(!isEnd) {
			count++;
		}
		
		return returnArr;
	}
	
	public static boolean isBoundary(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
