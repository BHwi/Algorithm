import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static int N;
	public static long answer = 0;
	public static int[] dx = {0, -1, -1, 0, 1, 1};
	public static int[] dy = {1, 0, 0, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		solve(-1, 25, 25, 0, new boolean[50][50], "");
		
		System.out.println(answer);
	}
	
	public static void solve(int count, int x, int y, int state, boolean[][] visited, String str) {
		if(count == -1) {
			visited[x][y] = true;
			visited[x + dx[0]][y + dy[0]] = true;
			solve(0, x + dx[0], y + dy[0], 0, visited, "");
		}
		else if(count == N) {
			return;
		}
		else {
			// i - 1 % 6
			int nextState = (6 + state - 1) % 6;
			
			if(visited[x + dx[nextState]][y + dy[nextState]]) {
				if(count == N - 1) answer++;
			}
			else {
				visited[x + dx[nextState]][y + dy[nextState]] = true;
				solve(count + 1, x + dx[nextState], y + dy[nextState], nextState, visited, str + nextState);
				visited[x + dx[nextState]][y + dy[nextState]] = false;
			}
			
			// i + 1 % 6
			nextState = (state + 1) % 6;
			
			if(visited[x + dx[nextState]][y + dy[nextState]]) {
				if(count == N - 1) answer++;
			}
			else {
				visited[x + dx[nextState]][y + dy[nextState]] = true;
				solve(count + 1, x + dx[nextState], y + dy[nextState], nextState, visited, str + nextState);
				visited[x + dx[nextState]][y + dy[nextState]] = false;
			}
		}
	}

}
