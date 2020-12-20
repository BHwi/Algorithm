import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger[][] arr = new BigInteger[n + 1][n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j) {
					arr[i][j] = new BigInteger("1");
				}
				else 
					arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j]);
			}
		}
		
		System.out.println(arr[n][m]);

	}

}
