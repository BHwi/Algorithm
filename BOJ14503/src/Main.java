import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int N, M, cx, cy, stat, arr[][], ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		cx = Integer.parseInt(st.nextToken());
		cy = Integer.parseInt(st.nextToken());
		stat = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		
		System.out.println(ans);
	}
	
	public static void solve() {
		// not clean : 0
		// wall : 1
		// clean : 2
		loop :
		while(true) {
			// System.out.println("cx : " + cx + " cy : " + cy + " stat : " + stat);
			if(arr[cx][cy] == 0) {
				arr[cx][cy] = 2;
				ans++;
			}
			
			for(int i = 1; i <= 4; i++) {
				int nstat = stat - i < 0 ? stat - i + 4 : stat - i;
				
				int nx = cx + dx[nstat];
				int ny = cy + dy[nstat];
				
				if(arr[nx][ny] == 0) { 
					cx = nx;
					cy = ny;
					stat = nstat;
					continue loop;
				}
			}
			
			int back = stat <= 1 ? stat + 2 : stat - 2;
			int backx = cx + dx[back];
			int backy = cy + dy[back];
			
			if(arr[backx][backy] == 2) {
				cx = backx;
				cy = backy;
			}
			else if(arr[backx][backy] == 1) {
				break;
			}
		}
		
	}

}
