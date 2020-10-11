import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int[][] arr;
	public static int m, n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[m][n];
		int[][] tmp_arr = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		tmp_arr[0][0] = 1;
		recursion(tmp_arr);
		
		System.out.println(tmp_arr[m-1][n-1]);
		
		sc.close();
	}
	
	public static void recursion(int[][] tmp_arr) {
		Deque<Integer> x_queue = new ArrayDeque<Integer>();
		Deque<Integer> y_queue = new ArrayDeque<Integer>();
		
		x_queue.add(0);
		y_queue.add(0);
		
		int[] dx = {-1, 1, 0, 0}; int[] dy = {0, 0, -1, 1};
		
		while(!x_queue.isEmpty()) {
			int x = x_queue.poll();
			int y = y_queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i], ny = y + dy[i];
				
				if(nx < m && ny < n && nx >= 0 && ny >= 0 && arr[x][y] > arr[nx][ny]) {
					x_queue.add(nx);
					y_queue.add(ny);
					tmp_arr[nx][ny]++;
				}
			}
		}
		
	}

}
