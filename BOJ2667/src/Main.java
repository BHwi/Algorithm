import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int n;
	public static int[] tmp_answer, answer;
	public static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		n = sc.nextInt();
		sc.nextLine();
		tmp_answer = new int[n];
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) == '1' ? 1 : 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 1) {
					tmp_answer[count++] = bfs(arr, i, j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(count);
		
		answer = new int[count];
		
		for(int i = 0; i < count; i++) {
			answer[i] = tmp_answer[i];
		}
		
		Arrays.sort(answer);
		
		for(int i = 0; i < count; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static int bfs(int[][] arr, int i, int j) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		int[] start = {i, j};
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int count = 1;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x = tmp[0];
			int y = tmp[1];
			arr[x][y] = 0;
			
			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(arr[nx][ny] == 1) {
						arr[nx][ny] = 0;
						int[] putQueue = {nx, ny};
						queue.add(putQueue);
						count++;
					}
				}
			}
		}
		
		return count;
	}

}
