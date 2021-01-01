import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer input = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(input.nextToken());
		int M = Integer.parseInt(input.nextToken());
		int B = Integer.parseInt(input.nextToken());
		int max = 0, min = 2147000000, answerTime = 2147000000, answerHeight = -1;
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > max) max = arr[i][j];
				if(arr[i][j] < min) min = arr[i][j];
			}
		}
		
		int height = max;
		
		while(height >= min) {
			int time = 0;
			int bag = B;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(arr[i][j] == height) continue;
					else {
						int d = Math.abs(height - arr[i][j]);
						
						if(height > arr[i][j]) {
							bag -= d;
							time += d;
						}
						else {
							bag += d;
							time += (2 * d);
						}
					}
				}
			}
			if(bag < 0) continue;
			if(time < answerTime) {
				answerTime = time;
				answerHeight = height;
			}
			height--;
		}
		
		System.out.println(answerTime + " " + answerHeight);
		
		
	}

}
