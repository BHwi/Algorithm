import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr;
	public static int N, white = 0, blue = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Paper> q = new ArrayDeque<Paper>();
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new Paper(0, 0, N));
		
		while(!q.isEmpty()) {
			Paper p = q.poll();
			
			if(isSquare(p)) {
				if(arr[p.x][p.y] == 0) white++;
				else blue++;
			} else {
				int n = p.n;
				q.add(new Paper(p.x, p.y, n / 2));
				q.add(new Paper(p.x + n / 2, p.y, n / 2));
				q.add(new Paper(p.x, p.y + n / 2, n / 2));
				q.add(new Paper(p.x + n / 2, p.y + n / 2, n / 2));
			}
		}
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static class Paper{
		// ÁÂÇ¥ : x, y
		// ±æÀÌ : n
		
		int x, y, n;
		
		Paper(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	public static boolean isSquare(Paper p) {
		int color = arr[p.x][p.y];
		
		for(int i = p.x; i < p.x + p.n; i++) {
			for(int j = p.y; j < p.y + p.n; j++) {
				if(arr[i][j] != color)
					return false;
			}
		}
		
		return true;
	}

}
