import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boolean[][] arr = new boolean[100][100];
		int count = 0;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x = x1; x < x2; x++) {
				for(int y = y1; y < y2; y++) {
					if(!arr[x][y]) {
						arr[x][y] = true;
						count++;
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
