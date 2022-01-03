import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Node {
		int idx, d;
		
		Node(int idx, int d) {
			this.idx = idx;
			this.d = d;
		}
	}
	public static Node[] node;
	public static ArrayList<Node>[] list;
	public static int[] d, input;
	public static boolean[] visited;
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T, x, y, w;
		
		T = stoi(br.readLine());
		
		for(int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine());
			
			N = stoi(st.nextToken());
			K = stoi(st.nextToken());
			
			node = new Node[N + 1];
			list = new ArrayList[N + 1];
			d = new int[N + 1];
			input = new int[N + 1];
			visited = new boolean[N + 1];
			for(int i = 0; i <= N; i++) 
				list[i] = new ArrayList<Node>();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= N; i++) {
				node[i] = new Node(i, stoi(st.nextToken()));
				d[i] = node[i].d;
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = stoi(st.nextToken());
				int end = stoi(st.nextToken());
				
				list[start].add(node[end]);
				input[end]++;
			}
			
			w = stoi(br.readLine());
			
			System.out.println(topology(w));
		}
	}
	
	public static int topology(int w) {
		int i = 0;
		
		while(i < N) {
			for(int j = 1; j <= N; j++) {
				if(input[j] == 0 && !visited[j]) {
					visited[j] = true;
					ArrayList<Node> next = list[j];
					
					for(int k = 0; k < next.size(); k++) {
						if(d[next.get(k).idx] < d[j] + next.get(k).d) {
							d[next.get(k).idx] = d[j] + next.get(k).d;
						}
						input[next.get(k).idx]--;
					}
					break;
				}
			}
			
			i++;
		}
		
		return d[w];
	}
}
