import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int x, y, cnt, broken;
		
		public Node(int x, int y, int cnt, int broken) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.broken = broken;
		}
	}
	
	public static final int INF = 1000001;
	public static int N, M, min = INF;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	public static int[][] arr;
	public static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[2][N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.charAt(j) + "");
			}
		}
		
		bfs();
		
		System.out.println(min == INF ? -1 : min);
	}
	
	public static void bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.offer(new Node(0, 0, 1, 0));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			
			int x = curNode.x;
			int y = curNode.y;
			int cnt = curNode.cnt;
			int broken = curNode.broken;
			
			if(x == N - 1 && y == M - 1) {
				min = Math.min(min, cnt);
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int curx = x + dx[i];
				int cury = y + dy[i];
				
				if(isBoundary(curx, cury)) {
					if(broken == 1) {
						if(!visited[broken][curx][cury] && arr[curx][cury] == 0) {
							visited[broken][curx][cury] = true;
							q.offer(new Node(curx, cury, cnt + 1, broken));
						}
					} else {
						if(arr[curx][cury] == 1) {
							if(!visited[broken + 1][curx][cury]) {
								visited[broken + 1][curx][cury] = true;
								q.offer(new Node(curx, cury, cnt + 1, broken + 1));
							}
						} else if(arr[curx][cury] == 0) {
							if(!visited[broken][curx][cury]) {
								visited[broken][curx][cury] = true;
								q.offer(new Node(curx, cury, cnt + 1, broken));
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean isBoundary(int x, int y) {
		return (x >= 0 && x < N) && (y >= 0 && y < M);
	}

}
