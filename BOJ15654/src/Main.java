import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int n, m, i, j;
	public static int[] arr, visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		visited = new int[n];
		
		for(i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(i = 0; i < arr.length; i++) {
			recursion(i, 1, "");
		}
		
	}
	
	public static void recursion(int value, int num, String str) {
		visited[value] = 1;
		str += arr[value];
		
		if(num == m) {
			System.out.println(str);
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(visited[i] == 0) {
				recursion(i, num + 1, str + " ");
			}
		}
		visited[value] = 0;
	}

}
