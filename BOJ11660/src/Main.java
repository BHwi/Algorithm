import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N + 1][N + 1];
		
		for(int x = 1; x <= N; x++) {
			st = new StringTokenizer(br.readLine());
			
			arr[x][1] = Integer.parseInt(st.nextToken());
			
			for(int y = 2; y <= N; y++) {
				arr[x][y] = arr[x][y - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < M; i++) {
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j <= x2; j++) {
				sum += arr[j][y2] - arr[j][y1 - 1];
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.print(sb);
	}

}
