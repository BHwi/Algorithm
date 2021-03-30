import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		
	}
	public static ArrayList<Integer> list[];
	public static int N, max = 0, start[], end[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		start = new int[N + 1];
		end = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int tmp = 0;
			
			for(int j = 0; j < M; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				tmp = Math.max(tmp, end[input]);
			}
			
			start[i] = tmp;
			end[i] = start[i] + T;
			
			max = Math.max(max, end[i]);
		}
		
		System.out.println(max);
		
	}

}
