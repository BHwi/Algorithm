import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] arr1 = new int[T], arr2 = new int[T];
		
		for(int i = 0; i < T; i++) {
			arr1[i] = sc.nextInt();
			arr2[i] = sc.nextInt();
		}
		
		for(int i = 0; i < T; i++) {
			System.out.println(bfs(arr1[i], arr2[i]));
		}
		
		
	}
	
	public static String bfs(int from, int to) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[10000];
		String[] command = new String[10000];
		visited[from] = true;
		
		queue.add(from);
		Arrays.fill(command,"");
		
		while(!queue.isEmpty() && !visited[to]) {
			int tmp = queue.poll();
			int D = tmp * 2 % 10000;
			int S = tmp - 1 == -1 ? 9999 : tmp - 1;
			int L = (tmp % 1000) * 10 + tmp / 1000;
			int R = (tmp % 10) * 1000 + tmp / 10;
						
			// D
			if(!visited[D]) {
				queue.add(D);
				visited[D] = true;
				command[D] = command[tmp] + "D";
			}
			// S
			if(!visited[S]) {
				queue.add(S);
				visited[S] = true;
				command[S] = command[tmp] + "S";
			}
			// L
			if(!visited[L]) {
				queue.add(L);
				visited[L] = true;
				command[L] = command[tmp] + "L";
			}
			// R
			if(!visited[R]) {
				queue.add(R);
				visited[R] = true;
				command[R] = command[tmp] + "R";
			}
		}
		
		return command[to];
	}

}
