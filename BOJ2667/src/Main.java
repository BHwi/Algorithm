import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> ans = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			arr[i] = input.toCharArray();
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == '1') {
					int count = 0;
					Deque<Point> q = new ArrayDeque<>();
					
					q.add(new Point(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Point p = q.poll();
						arr[p.x][p.y] = '0';
						count++;
						
						for(int k = 0; k < 4; k++) {
							if(p.x + dx[k] >= 0 && p.x + dx[k] < N && p.y + dy[k] >= 0 && p.y + dy[k] < N) {
								if(!visited[p.x + dx[k]][p.y + dy[k]] && arr[p.x + dx[k]][p.y + dy[k]] == '1') {
									q.add(new Point(p.x + dx[k], p.y + dy[k]));
									visited[p.x + dx[k]][p.y + dy[k]] = true;
								}
							}
						}
					}
					ans.add(count);
				}
			}
		}
		
		Collections.sort(ans);
		
		sb.append(ans.size() + "\n");
		
		Iterator<Integer> itr = ans.iterator();
		
		while(itr.hasNext())
			sb.append(itr.next() + "\n");
		
		System.out.print(sb);
		
	}

	public static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
