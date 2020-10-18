import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<object> queue = new ArrayDeque<object>();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] visited = new int[100001];
		
		if(k <= n) {
			System.out.println(n - k);
			System.exit(0);
		}
		
		queue.add(new object(n, 0));
		
		while(!queue.isEmpty()) {
			object tmp = queue.poll();
			
			if(tmp.number == k) {
				System.out.println(tmp.count);
				System.exit(0);
			}
			
			if(tmp.number + 1 <= 100000 && visited[tmp.number + 1] == 0) {
				visited[tmp.number + 1] = 1;
				queue.add(new object(tmp.number + 1, tmp.count + 1));
			}
			
			if(tmp.number - 1 >= 0 && visited[tmp.number - 1] == 0) {
				visited[tmp.number - 1] = 1;
				queue.add(new object(tmp.number - 1, tmp.count + 1));
				}
			
			if(tmp.number * 2 <= 100000 && visited[tmp.number * 2] == 0) {
				visited[tmp.number * 2] = 1;
				queue.add(new object(tmp.number * 2, tmp.count + 1));
			}
		}
		
		sc.close();
	}
	
	public static class object {
		public int number, count;
		
		object(int number, int count){
			this.number = number;
			this.count = count;
		}
	}

}
