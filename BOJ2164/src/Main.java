import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) 
			queue.add(i);
		
		boolean remove = true;
		
		while(queue.size() > 1) {
			if(remove) {
				queue.poll();
				remove = false;
			}
			else {
				queue.add(queue.poll());
				remove = true;
			}
		}
		
		System.out.println(queue.poll());
	}

}
