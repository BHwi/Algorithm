import java.util.Scanner;

public class Main {
	public static boolean[][] map;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		map = new boolean[n][2 * n - 1];

		draw(0, n - 1, n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2 * n - 1; j++) {
				if(map[i][j]) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	public static void draw(int x, int y, int n) {
		if (n == 3) {
			map[x][y] = true;
			map[x+1][y-1] = true;
			map[x+1][y+1] = true;
			map[x+2][y-2] = true;
			map[x+2][y-1] = true;
			map[x+2][y+0] = true;
			map[x+2][y+1] = true;
			map[x+2][y+2] = true;	
			return;
		}
		
		draw(x, y, n / 2);
		draw(x + n / 2, y - n / 2, n / 2);
		draw(x + n / 2, y + n / 2, n / 2);
	}

}
