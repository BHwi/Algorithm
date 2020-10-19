import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	
	public static int n, m, count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[][] computer = new int[n + 1][n + 1];
		int[] size = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		for(int i = 0; i < m; i++) {
			int j = sc.nextInt();
			int k = sc.nextInt();
			
			computer[j][size[j]++] = k;
			computer[k][size[k]++] = j;
		}
		
		queue.add(1);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i = 0; i < computer[tmp].length; i++) {
				if(computer[tmp][i] > 0 && !visited[computer[tmp][i]]) {
					queue.add(computer[tmp][i]);
					visited[computer[tmp][i]] = true;
				}
			}
		}
		
		for(int i = 2; i < visited.length; i++)
			if(visited[i]) count++;
		
		System.out.println(count);
		
	}
}
