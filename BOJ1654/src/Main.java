import java.io.*;

public class Main {
	public static int n, k;
	public static long max = 0;
	public static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		
		n = Integer.parseInt(st[0]);
		k = Integer.parseInt(st[1]);
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		
		System.out.println(Binary(1, max, k));

	}
	
	public static long Binary(long start, long end, int target) {
		long m = (start + end) / 2;
		
		if(end < start) 
			return end;
		
		if(rope(m) >= target) {
			return Binary(m + 1, end, target);
		}
		else if(rope(m) < target) {
			return Binary(start, m - 1, target);
		}
		
		return -1;
	}
	
	public static int rope(long length) {
		int count = 0;
		
		for(int i = 0; i < arr.length; i++)
			count += arr[i] / length;
		 
		return count;
	}

}
