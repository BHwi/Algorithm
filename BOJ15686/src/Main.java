import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static class Point {
		int x, y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static int N, M, min = 100000, arr[][], dp[][];
	public static ArrayList<Point> house, chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					house.add(new Point(i, j));
				}
				else if(arr[i][j] == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		
		dp = new int[house.size()][chicken.size()];
		
		for(int i = 0; i < house.size(); i++) {
			for(int j = 0; j < chicken.size(); j++) {
				dp[i][j] = count(house.get(i), chicken.get(j));
			}
		}
		
		solve(new int[M], new boolean[chicken.size()], 0);
		
		System.out.println(min);
	}
	
	public static void solve(int[] list, boolean[] visited, int count) {
		if(count == M) {
			int sum = 0;
			
			for(int i = 0; i < house.size(); i++) {
				int tmp = 100000;
				
				for(int j = 0; j < M; j++) {
					tmp = Math.min(tmp, dp[i][list[j]]);
				}
				
				sum += tmp;
			}
			
			min = Math.min(sum, min);
			visited[count - 1] = false;
			list[count - 1] = 0;
		}
		else {
			if(count == 0) {
				for(int i = 0; i < chicken.size(); i++) {
					list[count] = i;
					visited[i] = true;
					solve(list, visited, count + 1);
					visited[i] = false;
					list[count] = 0;
				}
			}
			else {
				for(int i = 0; i < chicken.size(); i++) {
					if(!visited[i] && list[count - 1] < i) {
						list[count] = i;
						visited[i] = true;
						solve(list, visited, count + 1);
						visited[i] = false;
						list[count] = 0;
					}
				}
			}
		}
	}
	
	public static int count(Point house, Point chicken) {
		return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
	}

}
