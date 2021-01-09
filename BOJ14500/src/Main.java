import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static int[][][] arr;
	public static int N, M, size;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		size = N > M ? N : M;
		arr = new int[8][size][size];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) 
				arr[0][i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < 8; i++) {
			arr[i] = flip(arr[i-1], i);
		}
		
		int max = 0;
		int[][] dx = {{0, 0, 0, 0}, {0, 0, 1, 1}, {0, 1, 2, 2}, {0, 1, 1, 2}, {0, 0, 0, 1}};
		int[][] dy = {{0, 1, 2, 3}, {0, 1, 0, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 2, 1}};
		
		for(int T = 0; T < 8; T++) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					loop :
					for(int k = 0; k < 5; k++) {
						int count = 0;
						for(int l = 0; l < 4; l++) {
							int idx = i + dx[k][l];
							int idy = j + dy[k][l];
							
							if(idx >= 0 && idx < size && idy >= 0 && idy < size) 
								count += arr[T][idx][idy];
							else
								continue loop;
						}
						max = Math.max(count, max);
					}
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public static int[][] flip(int[][] arr, int status) {
		int[][] flip_arr = new int[size][size];
		
		if(status != 4) {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					flip_arr[i][j] = arr[j][size - i - 1];
				}
			}
		}
		else {
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					flip_arr[i][j] = arr[i][size - j - 1];
				}
			}
		}
		return flip_arr;
	}

}
