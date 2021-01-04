import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N --> 0) {
			int input = Integer.parseInt(br.readLine());
			
			switch(input) {
			case 0:
				if(pq.peek() == null) sb.append(0 + "\n");
				else  sb.append(pq.poll() + "\n");
				break;
			
			default :
				pq.add(input);
			}
		}
		
		System.out.print(sb);

	}

}
