import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int R, C, max = 0;
	public static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R + 1][C + 1];
		
		for(int i = 1; i <= R; i++) {
			arr[i] = (" " + br.readLine()).toCharArray();
		}
		
		boolean[] al = new boolean[26];
		al[arr[1][1] - 'A'] = true;
		
		dfs(1, 1, 1, al);
		
		System.out.println(max);
	}
	
	// backtracking
	public static void dfs(int x, int y, int count, boolean[] al) {
		max = Math.max(max, count);
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isBoundary(nx, ny)) {
				if(!al[arr[nx][ny] - 'A']) {
					al[arr[nx][ny] - 'A'] = true;
					dfs(nx, ny, count + 1, al);
					al[arr[nx][ny] - 'A'] = false;
				}
			}
		}
	}
	
	public static boolean isBoundary(int x, int y) {
		return x >= 1 && x <= R && y >= 1 && y <= C;
	}

}
