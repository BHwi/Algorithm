import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>(); 
		
		int n = Integer.parseInt(br.readLine());
	
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			if(s.equals("pop_front")) {
				if(q.size() == 0) sb.append(-1 + "\n");
				else sb.append(q.removeFirst() + "\n");
			}
			else if(s.equals("pop_back")) {
				if(q.size() == 0) sb.append(-1 + "\n");
				else sb.append(q.removeLast() + "\n");
			}
			else if(s.equals("size")) {
				sb.append(q.size() + "\n");
			}
			else if(s.equals("empty")) {
				if(q.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			}
			else if(s.equals("front")) {
				if(q.size() == 0) sb.append(-1 + "\n");
				else sb.append(q.getFirst() + "\n");
			}
			else if(s.equals("back")) {
				if(q.size() == 0) sb.append(-1 + "\n");
				else sb.append(q.getLast() + "\n");
			}
			else {
				String[] st = s.split(" ");
				if(st[0].equals("push_front")) {
					q.addFirst(Integer.parseInt(st[1]));
				}
				if(st[0].equals("push_back")) {
					q.addLast(Integer.parseInt(st[1]));
				}
			}
		}
		
		System.out.print(sb);

	}

}
