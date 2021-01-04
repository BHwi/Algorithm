import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int number = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int x = 0, y = 0, answer = 0;
		while(N > 1) {
			N /= 2;
			
			if(r < x + N && c < y + N) {
				continue;
			}
			else if(r < x + N && c >= y + N) {
				answer += N * N * 1;
				y += N;
			}
			else if(r >= x + N && c < y + N) {
				answer += N * N * 2;
				x += N;
			}
			else {
				answer += N * N * 3;
				x += N;
				y += N;
			}
		}
		System.out.println(answer);
		
	}

}
