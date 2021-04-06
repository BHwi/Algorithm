import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		int rx, ry, bx, by, count;

		Node(int rx, int ry, int bx, int by, int count) {
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
		}
	}

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int N, M, rx, ry, bx, by, min = 11;
	public static boolean b = false;
	public static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);

				if (arr[i][j] == 'R') {
					rx = i;
					ry = j;
					arr[i][j] = '.';
				}
				if (arr[i][j] == 'B') {
					bx = i;
					by = j;
					arr[i][j] = '.';
				}
			}
		}

		solve();
		
		if(b) {
			System.out.println(min);
		}
		else {
			System.out.println(-1);
		}
	}

	public static void solve() {
		ArrayDeque<Node> q = new ArrayDeque<>();

		q.add(new Node(rx, ry, bx, by, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.count > min || cur.count > 10) break;
			
			if(cur.bx == -1) {
				continue;
			}
			
			if(cur.rx == -1 && cur.bx != -1) {
				min = Math.min(min, cur.count);
				b = true;
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				Node n = roll(cur, i);
				q.add(n);
			}
		}

	}

	public static Node roll(Node node, int stat) {
		int rx = node.rx;
		int ry = node.ry;
		int bx = node.bx;
		int by = node.by;
		
		if(whoIsFirst(node, stat) == 0) {
			// red first
			while(arr[rx + dx[stat]][ry + dy[stat]] != '#') {
				if(arr[rx + dx[stat]][ry + dy[stat]] == 'O') {
					rx = -1;
					ry = -1;
					break;
				}
				rx += dx[stat];
				ry += dy[stat];
			}
			while(arr[bx + dx[stat]][by + dy[stat]] != '#') {
				if(arr[bx + dx[stat]][by + dy[stat]] == 'O') {
					bx = -1;
					by = -1;
					break;
				}
				if(bx + dx[stat] == rx && by + dy[stat] == ry) {
					break;
				}
				bx += dx[stat];
				by += dy[stat];
			}
		}
		else {
			// blue first
			while(arr[bx + dx[stat]][by + dy[stat]] != '#') {
				if(arr[bx + dx[stat]][by + dy[stat]] == 'O') {
					bx = -1;
					by = -1;
					break;
				}
				bx += dx[stat];
				by += dy[stat];
			}
			while(arr[rx + dx[stat]][ry + dy[stat]] != '#') {
				if(arr[rx + dx[stat]][ry + dy[stat]] == 'O') {
					rx = -1;
					ry = -1;
					break;
				}
				if(rx + dx[stat] == bx && ry + dy[stat] == by) {
					break;
				}
				rx += dx[stat];
				ry += dy[stat];
			}
		}
		
		return new Node(rx, ry, bx, by, node.count + 1);
	}
	
	public static int whoIsFirst(Node node, int stat) {
		if(stat == 0 && node.rx < node.bx) return 0;
		else if(stat == 1 && node.rx > node.bx) return 0;
		else if(stat == 2 && node.ry < node.by) return 0;
		else if(stat == 3 && node.ry > node.by) return 0;
		else return 1;
	}

}
