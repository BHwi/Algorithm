import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static char[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				arr[i][j] = input[j];
			}
		}
		
		Deque<Node> q = new ArrayDeque<>();
		int normal = 0, colorweak = 0;
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					char now = arr[i][j];
					q.add(new Node(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Node n = q.poll();
						
						for(int k = 0; k < 4; k++) {
							int idx = n.x + dx[k];
							int idy = n.y + dy[k];
							
							if(idx >= 0 && idx < N && idy >= 0 && idy < N && !visited[idx][idy]) { 
								if(arr[idx][idy] == now) {
									q.add(new Node(idx, idy));
									visited[idx][idy] = true;
								}
								else if(now == 'R' && arr[idx][idy] == 'G') {
									q.add(new Node(idx, idy));
									visited[idx][idy] = true;
								}
								else if(now == 'G' && arr[idx][idy] == 'R') {
									q.add(new Node(idx, idy));
									visited[idx][idy] = true;
								}
							}
						}
					}
					colorweak++;
				}
			}
		}

		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					char now = arr[i][j];
					q.add(new Node(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Node n = q.poll();
						
						for(int k = 0; k < 4; k++) {
							int idx = n.x + dx[k];
							int idy = n.y + dy[k];
							
							if(idx >= 0 && idx < N && idy >= 0 && idy < N && !visited[idx][idy]) { 
								if(arr[idx][idy] == now) {
									q.add(new Node(idx, idy));
									visited[idx][idy] = true;
								}
							}
						}
					}
					normal++;
				}
			}
		}
		
		System.out.println(normal + " " + colorweak);

	}

	public static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
