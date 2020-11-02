import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static int n, k, min = 987654321, count = 0;
	public static boolean[] visited = new boolean[200001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		bfs();

		System.out.println(min);
		System.out.println(count);
	}

	public static void bfs() {
		Deque<object> queue = new ArrayDeque<object>();

		queue.add(new object(n, 0));
		visited[n] = true;

		while (!queue.isEmpty()) {
			object tmp = queue.poll();
			visited[tmp.value] = true;
			
			if (tmp.count > min) {
				continue;
			}

			if (tmp.value == k) {
				min = Math.min(min, tmp.count);
				count++;
			} else {
				if (tmp.value - 1 >= 0 && !visited[tmp.value - 1]) {
					queue.add(new object(tmp.value - 1, tmp.count + 1));
				}
				if (tmp.value + 1 <= k && !visited[tmp.value + 1]) {
					queue.add(new object(tmp.value + 1, tmp.count + 1));
				}
				if (tmp.value * 2 < 2 * k && !visited[tmp.value * 2]) {
					queue.add(new object(tmp.value * 2, tmp.count + 1));
				}
			}
		}
	}

	public static class object {
		int value, count;

		object(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}

}
