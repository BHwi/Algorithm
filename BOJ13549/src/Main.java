import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static final int MAX = 987654321;
	public static int n, k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		int[] answer = new int[100001];
		Arrays.fill(answer, MAX);
		
		queue.add(n);
		answer[n] = 0;
		
		while(!queue.isEmpty() && answer[k] == MAX) {
			int tmp = queue.poll();
			int i = tmp;
			
			// 순간이동으로 갈 수 있는 곳
			if(i != 0) {
				while(i < 2 * k && i * 2 < 100001) {
					i *= 2;
					answer[i] = answer[tmp];
					queue.add(i);
				}
			}
			
			if(tmp < 100000) {
				if(answer[tmp + 1] == MAX) {
					answer[tmp + 1] = answer[tmp] + 1;
					queue.add(tmp + 1);
				}
			}
			
			if(tmp > 0) {
				if(answer[tmp - 1] == MAX) {
					answer[tmp - 1] = answer[tmp] + 1;
					queue.add(tmp - 1);
				}
			}
			
		}
		
		return answer[k];
	}

}
