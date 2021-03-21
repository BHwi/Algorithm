import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static class PuriMachine {
		int x, y;

		public PuriMachine(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int R, C, T;
	public static int[][] arr;
	public static PuriMachine[] puriMachine = new PuriMachine[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == -1) {
					if (puriMachine[0] == null) {
						puriMachine[0] = new PuriMachine(i, j);
					} else {
						puriMachine[1] = new PuriMachine(i, j);
					}
				}
			}
		}

		while (T-- > 0) {
			diffuse();
			purify();
		}

		int answer = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != -1) {
					answer += arr[i][j];
				}
			}
		}

		System.out.println(answer);
	}

	public static void diffuse() {
		int[][] plus_arr = new int[R][C];
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 4) {
					for (int k = 0; k < 4; k++) {
						if (i + dx[k] >= 0 && i + dx[k] < R && j + dy[k] >= 0 && j + dy[k] < C) {
							if (arr[i + dx[k]][j + dy[k]] != -1) {
								plus_arr[i + dx[k]][j + dy[k]] += arr[i][j] / 5;
								plus_arr[i][j] -= arr[i][j] / 5;
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arr[i][j] += plus_arr[i][j];
			}
		}
	}

	public static void purify() {
		int m1 = puriMachine[0].x;
		int m2 = puriMachine[1].x;

		// up
		for (int i = m1 - 1; i > 0; i--)
			arr[i][0] = arr[i - 1][0];
		
		for (int i = 0; i < C - 1; i++)
			arr[0][i] = arr[0][i + 1];
		
		for (int i = 0; i < m1; i++)
			arr[i][C - 1] = arr[i + 1][C - 1];
		
		for (int i = C - 1; i > 1; i--)
			arr[m1][i] = arr[m1][i - 1];
		
		arr[m1][1] = 0;

		// down
		for (int i = m2 + 1; i < R - 1; i++)
			arr[i][0] = arr[i + 1][0];
		
		for (int i = 0; i < C - 1; i++)
			arr[R - 1][i] = arr[R - 1][i + 1];
		
		for (int i = R - 1; i > m2; i--)
			arr[i][C - 1] = arr[i - 1][C - 1];
		
		for (int i = C - 1; i > 1; i--)
			arr[m2][i] = arr[m2][i - 1];
		
		arr[m2][1] = 0;

	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
