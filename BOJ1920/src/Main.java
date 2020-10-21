import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int m = sc.nextInt();
		int[] answer = new int[m];
		
		for(int i = 0; i < m; i++) {
			int target = sc.nextInt();
			answer[i] = binarySearch(arr, target, 0, arr.length - 1);
		}
		
		for(int i = 0; i < m; i++)
			System.out.println(answer[i]);

	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		if(start > end) {
			return 0;
		} else {
			int mid = (start + end) / 2;
			
			if(arr[mid] == target) {
				return 1;
			} else if(target < arr[mid]) {
				return binarySearch(arr, target, start, mid - 1);
			} else {
				return binarySearch(arr, target, mid + 1, end);
			}
		}
	}

}
