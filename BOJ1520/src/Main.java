import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int N, M;
	public static int[][] dp, arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(search(0, 0));
	}
	
	public static int search(int x, int y) {
		if(x == N - 1 && y == M - 1) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		else {
			dp[x][y] = 0;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(arr[nx][ny] < arr[x][y])
						dp[x][y] += search(nx, ny);
				}
			}
		}
		
		return dp[x][y];
	}
}
