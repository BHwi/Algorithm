import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {
	public static ArrayList<Integer> list[];
	public static int N, ans_arr[], ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		ans_arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			int M = Integer.parseInt(br.readLine());
			if(i == M) ans_arr[i] = 1;
			
			list[i].add(M);
		}
		
		for(int i = 1; i <= N; i++) {
			solve(i);
		}
		
		for(int i = 1; i <= N; i++) {
			if(ans_arr[i] == 1) {
				ans++;
				sb.append(i + "\n");
			}
		}
		
		System.out.println(ans);
		System.out.print(sb.toString());
	}
	
	public static void solve(int start) {
		ArrayList<Integer> tmp = new ArrayList<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int curNode = q.poll();
			tmp.add(curNode);
			
			visited[curNode] = true;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i);
				if(visited[nextNode] && start == nextNode) {
					for(int j = 0; j < tmp.size(); j++) {
						ans_arr[tmp.get(j)] = 1;
					}
					return;
				}
				if(!visited[nextNode]) {
					q.add(nextNode);
				}
			}
		}
	}

}
