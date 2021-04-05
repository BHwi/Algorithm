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
	
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, M, sum = 0, ans = 0, arr[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
		}
		
		while(sum > 0) {
			ans++;
			arr = melt();
			isSeparated();
		}
		
		System.out.println(0);
	}
	
	public static int[][] melt() {
		int[][] return_arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0) 
					continue;
				else {
					return_arr[i][j] = arr[i][j];
					
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(arr[nx][ny] == 0) {
							return_arr[i][j]--;
							sum--;
						}
					}
					
					if(return_arr[i][j] < 0) {
						sum -= return_arr[i][j];
						return_arr[i][j] = 0;
					}
				}
			}
		}
		
		return return_arr;
	}
	
	public static void isSeparated() {
		int tmp_sum = sum;
		boolean[][] visited = new boolean[N][M];
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] == 0)
					continue;
				else {
					if(!visited[i][j]) {
						q.add(new Point(i, j));
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							Point cur = q.poll();
							int curx = cur.x;
							int cury = cur.y;
							
							tmp_sum -= arr[curx][cury];
							
							for(int k = 0; k < 4; k++) {
								int nx = curx + dx[k];
								int ny = cury + dy[k];
								
								if(!visited[nx][ny] && arr[nx][ny] > 0) {
									visited[nx][ny] = true;
									q.add(new Point(nx, ny));
								}
							}
						}
						
						if(tmp_sum > 0) {
							System.out.println(ans);
							System.exit(0);
						}
					}
				}
			}
		}
	}
	
	public static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
