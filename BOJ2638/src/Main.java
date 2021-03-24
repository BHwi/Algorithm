import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, cnt = 0, ans = 0;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) cnt++;
			}
		}
		
		visited[0][0] = true;
		checkAir(0, 0);
		
		while(cnt != 0) {
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			
			visited = new boolean[N][M];
			visited[0][0] = true;
			checkAir(0, 0);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					arr[i][j] = arr[i][j] == 3 ? 2 : arr[i][j];
				}
			}
			
			ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void checkAir(int x, int y) {
		arr[x][y] = 2;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isBoundary(nx, ny) && !visited[nx][ny] && arr[nx][ny] != 1) {
				arr[nx][ny] = 2;
				visited[nx][ny] = true;
				checkAir(nx, ny);
			}
		}
	}
	
	public static void dfs(int x, int y) {
		if(arr[x][y] == 1 && melt(x, y)) {
			cnt--;
			arr[x][y] = 3;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isBoundary(nx, ny)) {
				if(!visited[nx][ny] && arr[nx][ny] != 0) {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static boolean melt(int x, int y) {
		int air = 0;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isBoundary(nx, ny)) {
				if(arr[nx][ny] == 2) air++;
			}
		}
		
		return air >= 2;
	}
	
	public static boolean isBoundary(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
}
