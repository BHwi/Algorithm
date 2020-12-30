import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			String[] input = br.readLine().split(" ");
			
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			int count = 0;
			LinkedList<Integer> queue = new LinkedList<>();
			

			for(int j = 0; j < n; j++) 
				queue.add(Integer.parseInt(input[j]));
			
			while(!queue.isEmpty()) {
				boolean isPriorty = true;
				
				for(int j = 1; j < queue.size(); j++) {
					if(queue.peek() < queue.get(j)) {
						isPriorty = false;
						break;
					}
				}
				
				if(isPriorty) {
					count++;
					queue.poll();
					
					if(m == 0)
						break;
					else
						m -= 1;
				}
				else {
					int temp = queue.poll();
					queue.add(temp);
					m = m == 0 ? queue.size() - 1 : --m;
				}
			}
			sb.append(count + "\n");
		}
		
		
		System.out.println(sb);

	}

}
