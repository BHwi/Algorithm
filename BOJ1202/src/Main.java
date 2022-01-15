import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Item implements Comparable<Item> {
		int m, v;
		Item(int m, int v) {this.m = m; this.v = v;}
		@Override
		public int compareTo(Item o) {
			if(this.m == o.m) {
				return o.v - this.v;
			}
			else {
				return this.m - o.m;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long result = 0;
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		
		Item[] item = new Item[N];
		int[] bag = new int[K];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i] = new Item(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		
		for(int i = 0; i < K; i++) {
			bag[i] = stoi(br.readLine());
		}
		
		Arrays.sort(item);
		Arrays.sort(bag);
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		int idx = 0;
		
		for(int i = 0; i < K; i++) {
			while(idx < N && item[idx].m <= bag[i]) {
				pq.add(item[idx].v);
				idx++;
			}
			if(!pq.isEmpty()) result += pq.poll();
		}
		
		System.out.println(result);
	}

}
