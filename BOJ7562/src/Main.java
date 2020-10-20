import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int l;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		int[][] arr;
		int[] answer = new int[test];
		int[] start = new int[2], end = new int[2];
		
		for(int t = 0; t < test; t++) {
			l = sc.nextInt();
			arr = new int[l][l];
			
			start[0] = sc.nextInt();
			start[1] = sc.nextInt();
			
			end[0] = sc.nextInt();
			end[1] = sc.nextInt();
			
			answer[t] = bfs(arr, start, end);
		}
		
		for(int i = 0; i < test; i++)
			System.out.println(answer[i]);

	}
	
	public static int bfs(int[][] arr, int[] start, int[] end) {
		Deque<object> queue = new ArrayDeque<object>();
		
		int count = 0, x, y, nx, ny;
		int[] dx = {-1, 1, -1, 1, -2, 2, -2, 2};
		int[] dy = {2, 2, -2, -2, 1, 1, -1, -1};
		int[][] count_arr = new int[l][l];
		
		queue.add(new object(start[0], start[1]));
		arr[start[0]][start[1]] = 1;
		count_arr[start[0]][start[1]] = 0;
		
		while(!queue.isEmpty()) {
			object tmp = queue.poll();
			x = tmp.x;
			y = tmp.y;
			
			
			for(int i = 0; i < 8; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx >= 0 && nx < l && ny >= 0 && ny < l && arr[nx][ny] == 0) {
					arr[nx][ny] = 1;
					count_arr[nx][ny] = count_arr[x][y] + 1;
					queue.add(new object(nx, ny));
				}
			}
		}
				
		return count_arr[end[0]][end[1]];
	}
	
	public static class object {
		int x, y;
		
		object(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void print(int[][] arr) {
		for(int i = 0; i < l; i++) {
			for(int j = 0; j < l; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
