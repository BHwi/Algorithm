import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[][] arr;
	public static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Paper> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		answer = new int[3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new Paper(0, 0, N));
		
		while(!q.isEmpty()) {
			Paper tmp = q.poll();
			
			if(isPaper(tmp)) {
				answer[arr[tmp.x][tmp.y] + 1]++;
			} else {
				q.add(new Paper(tmp.x, tmp.y, tmp.n / 3));
				q.add(new Paper(tmp.x, tmp.y + (tmp.n / 3), tmp.n / 3));
				q.add(new Paper(tmp.x, tmp.y + 2 * (tmp.n / 3), tmp.n / 3));
				q.add(new Paper(tmp.x + (tmp.n / 3), tmp.y, tmp.n / 3));
				q.add(new Paper(tmp.x + (tmp.n / 3), tmp.y + (tmp.n / 3), tmp.n / 3));
				q.add(new Paper(tmp.x + (tmp.n / 3), tmp.y + 2 * (tmp.n / 3), tmp.n / 3));
				q.add(new Paper(tmp.x + 2 * (tmp.n / 3), tmp.y, tmp.n / 3));
				q.add(new Paper(tmp.x + 2 * (tmp.n / 3), tmp.y + (tmp.n / 3), tmp.n / 3));
				q.add(new Paper(tmp.x + 2 * (tmp.n / 3), tmp.y + 2 * (tmp.n / 3), tmp.n / 3));
			}
		}
		System.out.print(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
		
	}
	
	public static class Paper {
		// ÁÂÇ¥ x, y, Å©±â n
		int x, y, n;
		Paper(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	public static boolean isPaper(Paper p) {
		int tmp = arr[p.x][p.y];
		
		for(int i = p.x; i < p.x + p.n; i++) {
			for(int j = p.y; j < p.y + p.n; j++) {
				if(arr[i][j] != tmp) 
					return false;
			}
		}
		
		return true;
	}

}
