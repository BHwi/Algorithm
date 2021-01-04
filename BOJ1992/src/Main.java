import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static char[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			arr[i] = input.toCharArray();
		}
		
		System.out.println(recursion(0, 0, N));

	}
	
	public static String recursion(int x, int y, int n) {
		if(n == 1) {
			return arr[x][y] + "";
		}
		else if(isSquare(x, y, n)) {
			return arr[x][y] + "";
		}
		else {
			String str = "(";
			str += recursion(x, y, n / 2);
			str += recursion(x, y + n / 2, n / 2);
			str += recursion(x + n / 2, y, n / 2);
			str += recursion(x + n / 2, y + n / 2, n / 2);
			return str + ")";
		}
	}
	
	public static boolean isSquare(int x, int y, int n) {
		char ch = arr[x][y];
		
		for(int i = x; i < x + n; i++) 
			for(int j = y; j < y + n; j++) 
				if(arr[i][j] != ch) return false;
		
		return true;
	}

}
