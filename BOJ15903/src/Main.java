import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> q = new PriorityQueue<>();
		long Answer = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			q.add(Long.parseLong(st.nextToken()));
		}
		
		while(M --> 0) {
			long x = q.poll();
			long y = q.poll();
			
			q.add(x + y);
			q.add(x + y);
		}
		
		while(!q.isEmpty()) 
			Answer += q.poll();
		
		System.out.println(Answer);
	}

}
