import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	
	public static int N;
	public static int[] line;
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = stoi(br.readLine());
		line = new int[N];
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				
				line[i] += map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(line[i] % 2 == 1) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		dfs(0);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int current) {
		for(int i = 0; i < N; i++) {
			while(map[current][i] != 0) {
				map[current][i]--;
				map[i][current]--;
				dfs(i);
			}
		}
		
		sb.append((current + 1) + " ");
	}

}
