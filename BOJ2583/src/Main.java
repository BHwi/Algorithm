import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static int M, N, K, answer = 0;
	public static ArrayList<Integer> answer_list;
	public static boolean arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[M][N];
		answer_list = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j < x2; j++) {
				for(int k = y1; k < y2; k++) {
					arr[j][k] = true;
				}
			}
		}
		
		bfs();
		
		System.out.println(answer);
		
		Collections.sort(answer_list);
		
		for(int i = 0; i < answer_list.size(); i++) {
			System.out.print(answer_list.get(i) + " ");
		}
		
	}
	
	public static void bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		ArrayDeque<Point> q = new ArrayDeque<>();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!arr[i][j]) {
					int count = 1;
					arr[i][j] = true;
					q.add(new Point(i, j));
					
					while(!q.isEmpty()) {
						Point cur = q.poll();
						int curx = cur.x;
						int cury = cur.y;
						
						for(int k = 0; k < 4; k++) {
							int nx = curx + dx[k];
							int ny = cury + dy[k];
							
							if(nx >= 0 && nx < M && ny >=0 && ny < N) {
								if(!arr[nx][ny]) {
									count++;
									arr[nx][ny] = true;
									q.add(new Point(nx, ny));
								}
							}
						}
					}
					answer++;
					answer_list.add(count);
				}
			}
		}
	}

}
