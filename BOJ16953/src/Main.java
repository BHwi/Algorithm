import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<object> queue = new ArrayDeque<object>();
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		
		queue.add(new object(a, 0));
		
		while(!queue.isEmpty()) {
			object tmp = queue.poll();
			
			if(b == tmp.value) {
				System.out.println(tmp.count + 1);
				System.exit(0);
			} else if(tmp.value < b) {
				queue.add(new object(2 * tmp.value, tmp.count + 1));
				queue.add(new object(tmp.value * 10 + 1, tmp.count + 1));
			}
		}
		
		System.out.println(-1);

	}
	
	public static class object {
		long value; int count;
		
		object(long value, int count) {
			this.value = value;
			this.count = count;
		}
	}

}
