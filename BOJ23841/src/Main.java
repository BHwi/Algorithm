import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i] = st.nextToken().toCharArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				if(arr[i][j] != arr[i][M - j - 1]) {
					if(arr[i][j] != '.') {
						arr[i][M - j - 1] = arr[i][j];
					}
					else {
						arr[i][j] = arr[i][M - j - 1];
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
