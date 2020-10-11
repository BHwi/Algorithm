package p15649;

import java.util.*;

public class Main {
	
	static int[] arr; 
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		
		fun(0);
	}
	
	public static void fun(int i) {
		if(i == arr.length) {
			for(int j = 0; j < arr.length; j++)
				System.out.print(arr[j] + " ");
			System.out.println();
		}
		else {
			for(int j = 1; j <= n; j++) {
				if(!contain(j, i)) {
					arr[i] = j;
					fun(i+1);
				}
			}
		}
	}
	
	public static boolean contain(int j, int k) {
		for(int i = 0; i < k; i++)
			if(arr[i] == j) return true;
		return false;
	}
}
