import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][3];
		int[][] dp_max = new int[n][3];
		int[][] dp_min = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++)
				arr[i][j] = sc.nextInt();
		}
		
		dp_max[0][0] = arr[0][0];
		dp_max[0][1] = arr[0][1];
		dp_max[0][2] = arr[0][2];
		
		dp_min[0][0] = arr[0][0];
		dp_min[0][1] = arr[0][1];
		dp_min[0][2] = arr[0][2];
		
		for(int i = 1; i < n; i++) {
			dp_max[i][0] = Math.max(dp_max[i-1][0], dp_max[i-1][1]) + arr[i][0];
			dp_max[i][1] = Math.max(Math.max(dp_max[i-1][0], dp_max[i-1][1]), dp_max[i-1][2]) + arr[i][1];
			dp_max[i][2] = Math.max(dp_max[i-1][1], dp_max[i-1][2]) + arr[i][2];
			
			dp_min[i][0] = Math.min(dp_min[i-1][0], dp_min[i-1][1]) + arr[i][0];
			dp_min[i][1] = Math.min(Math.min(dp_min[i-1][0], dp_min[i-1][1]), dp_min[i-1][2]) + arr[i][1];
			dp_min[i][2] = Math.min(dp_min[i-1][1], dp_min[i-1][2]) + arr[i][2];
		}
		
		System.out.print(Math.max(Math.max(dp_max[n-1][0], dp_max[n-1][1]), dp_max[n-1][2]) + " ");
		System.out.print(Math.min(Math.min(dp_min[n-1][0], dp_min[n-1][1]), dp_min[n-1][2]));
	}

}
