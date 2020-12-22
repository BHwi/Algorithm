import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static int count = 0, n;
	public static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		arr = new int[n + 2][n + 2];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int tmp = sc.nextInt();
				if (tmp == 0) {
					arr[i][j] = 2;
				} else {
					arr[i][j] = tmp;
				}
			}
		}
		arr[1][1] = 5;
		arr[1][2] = 5;

		int x = 1, y = 2;

		dfs(x, y);

		System.out.println(count);

	}

	public static void dfs(int x, int y) {
		if (x == n && y == n) {
			count++;
			return;
		} else {
			if (arr[x][y - 1] == 5) { // 가로일때
				if (arr[x][y + 1] == 2) { // 가로확인
					arr[x][y - 1] = 2;
					arr[x][y + 1] = 5;
					dfs(x, y + 1);
					arr[x][y - 1] = 5;
					arr[x][y + 1] = 2;
				}
				if (arr[x + 1][y + 1] == 2 && arr[x][y + 1] != 1 && arr[x + 1][y] != 1) { // 대각선 확인
					arr[x][y - 1] = 2;
					arr[x + 1][y + 1] = 5;
					dfs(x + 1, y + 1);
					arr[x][y - 1] = 5;
					arr[x + 1][y + 1] = 2;
				}
			} else if (arr[x - 1][y] == 5) { // 세로일때
				if (arr[x + 1][y] == 2) { // 세로확인
					arr[x - 1][y] = 2;
					arr[x + 1][y] = 5;
					dfs(x + 1, y);
					arr[x - 1][y] = 5;
					arr[x + 1][y] = 2;
				}
				if (arr[x + 1][y + 1] == 2 && arr[x][y + 1] != 1 && arr[x + 1][y] != 1) { // 대각선 확인
					arr[x - 1][y] = 2;
					arr[x + 1][y + 1] = 5;
					dfs(x + 1, y + 1);
					arr[x - 1][y] = 5;
					arr[x + 1][y + 1] = 2;
				}
			} else if (arr[x - 1][y - 1] == 5) {
				if (arr[x][y + 1] == 2) { // 가로확인
					arr[x - 1][y - 1] = 2;
					arr[x][y + 1] = 5;
					dfs(x, y + 1);
					arr[x - 1][y - 1] = 5;
					arr[x][y + 1] = 2;
				}
				if (arr[x + 1][y] == 2) { // 세로확인
					arr[x - 1][y - 1] = 2;
					arr[x + 1][y] = 5;
					dfs(x + 1, y);
					arr[x - 1][y - 1] = 5;
					arr[x + 1][y] = 2;
				}
				if (arr[x + 1][y + 1] == 2 && arr[x][y + 1] != 1 && arr[x + 1][y] != 1) { // 대각선 확인
					arr[x - 1][y - 1] = 2;
					arr[x + 1][y + 1] = 5;
					dfs(x + 1, y + 1);
					arr[x - 1][y - 1] = 5;
					arr[x + 1][y + 1] = 2;
				}
			}
		}
	}

}
