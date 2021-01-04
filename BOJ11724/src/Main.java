import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static ArrayList<Integer>[] list;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(st.nextToken());

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			list[i].add(j);
			list[j].add(i);
		}

		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			Deque<Integer> q = new ArrayDeque<>();
			
			if (!visited[i]) {
				visited[i] = true;
				q.add(i);
				
				count++;
				
				while (!q.isEmpty()) {
					Iterator<Integer> itr;
					if(list[q.peek()] != null)
						itr = list[q.poll()].iterator();
					else {
						visited[q.peek()] = true;
						q.poll();
						continue;
					}

					while (itr.hasNext()) {
						int tmp = itr.next();
						if (!visited[tmp]) {
							q.add(tmp);
							visited[tmp] = true;
						}
					}
				}
			}
		}

		System.out.println(count);
	}

}
