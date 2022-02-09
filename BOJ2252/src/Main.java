import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) { return Integer.parseInt(s); }
	
	public static class Edge {
		int start, end;
		
		Edge(int start, int end) { this.start = start; this.end = end; }
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		int[] num = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		ArrayList<Edge>[] list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			list[a].add(new Edge(a, b));
			num[b]++;
		}
		
		int count = 0;
		
		while(count < N) {
			for(int i = 1; i < num.length; i++) {
				if(num[i] == 0 && !visited[i]) {
					System.out.print(i + " ");
					ArrayList<Edge> tmp = list[i];
					
					for(int j = 0; j < tmp.size(); j++) {
						num[tmp.get(j).end]--;
					}
					visited[i] = true;
					count++;
					break;
				}
			}
		}
	}

}
