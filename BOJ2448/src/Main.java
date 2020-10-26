import java.util.Scanner;

public class Main {
	public static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new char[n][2 * n - 1];
		
		for(int i = 0; i < n; i++) 
			for(int j = 0; j < 2 * n - 1; j++)
				map[i][j] = ' ';
		
		draw(0, n - 1, n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2 * n - 1; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}

	}
	
	public static void draw(int x, int y, int n) {
		if (n == 3) {
			map[x][y] = '*';
			map[x + 1][y - 1] = '*';
			map[x + 1][y + 1] = '*';
			map[x + 2][y - 2] = '*';
			map[x + 2][y - 1] = '*';
			map[x + 2][y + 0] = '*';
			map[x + 2][y + 1] = '*';
			map[x + 2][y + 2] = '*';
			return;
		}
		
		draw(x, y, n / 2);
		draw(x + n / 2, y - n / 2, n / 2);
		draw(x + n / 2, y + n / 2, n / 2);
	}

}
