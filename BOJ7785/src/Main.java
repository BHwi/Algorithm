import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String name, command;
		HashSet<String> s = new HashSet<>();
		
		int N = stoi(br.readLine());
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			
			name = st.nextToken();
			command = st.nextToken();
			
			if(command.equals("enter")) s.add(name);
			else s.remove(name);
		}
		
		PriorityQueue<String> q = new PriorityQueue<>((x, y) -> y.compareTo(x));
		
		Iterator<String> itr = s.iterator();
		
		while(itr.hasNext()) {
			q.add(itr.next());
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
