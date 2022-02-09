import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		int testcase = stoi(br.readLine());
		
		for(int T = 0; T < testcase; T++) {
			PriorityQueue<Integer> large = new PriorityQueue<>();
			PriorityQueue<Integer> small = new PriorityQueue<>((x, y) -> y - x);
			ArrayList<Integer> answer = new ArrayList<>();
			
			int M = stoi(br.readLine());
			int[] arr = new int[M];
			
			int mid = 0;
			
			for(int i = 0; i < M; i++) {
				if(i % 10 == 0)
					st = new StringTokenizer(br.readLine());
				arr[i] = stoi(st.nextToken());
			}
			
			for(int i = 0; i < arr.length; i++) {
				if(i == 0) {
					mid = arr[i];
				}
				else {
					if(arr[i] > mid) {
						large.add(arr[i]);
					}
					else {
						small.add(arr[i]);
					}
					
					if(i % 2 != 0) {
						continue;
					}
					else {
						if(large.size() > small.size()) {
							small.add(mid);
							mid = large.poll();
						}
						else if(large.size() < small.size()) {
							large.add(mid);
							mid = small.poll();
						}
					}
				}
				
				if(i % 2 == 0) 
					answer.add(mid);
			}
			
			System.out.print(answer.size());
			
			for(int i = 0; i < answer.size(); i++) {
				if(i % 10 == 0) System.out.println();
				System.out.print(answer.get(i) + " ");
			}
			
			System.out.println();
		}
	}

}
