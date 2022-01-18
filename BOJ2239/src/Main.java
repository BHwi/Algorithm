import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int[][] arr = new int[9][9];

	public static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();

			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.charAt(j) - '0';
				if (arr[i][j] == 0)
					list.add(new Node(i, j));
			}
		}

		int idx = 0;

		while (idx < list.size()) {
			Node tmp = list.get(idx);
			int x = tmp.x;
			int y = tmp.y;
			boolean b = false;

			for (int i = arr[x][y] + 1; i <= 9; i++) {
				if (check(x, y, i)) {
					arr[x][y] = i;
					idx++;
					b = true;
					break;
				}
			}
			if (b)
				continue;
			arr[x][y] = 0;
			idx--;
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static boolean check(int x, int y, int z) {
		// x, y : 해당 좌표, z : 넣으려는 숫자

		// 세로에서 같은 숫자가 있는지 확인
		for (int i = 0; i < 9; i++)
			if (arr[i][y] == z)
				return false;

		// 가로에서 같은 숫자가 있는지 확인
		for (int j = 0; j < 9; j++)
			if (arr[x][j] == z)
				return false;

		// 정사각형 내에서 같은 숫자가 있는지 확인
		for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
				if (arr[i][j] == z)
					return false;
			}
		}

		return true;
	}
}
