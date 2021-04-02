import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static String ans_str;
	public static long min = -1, arr[];
	public static int index, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new long[N];
		
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) 
					continue;
				else {
					index = search(arr[i] + arr[j]);
					
					if(index == i || index == j)
						continue;
					
					if(min == -1) {
						long sum = arr[i] + arr[j] + arr[index];
						min = Math.abs(sum);
						ans_str = answer(arr[i], arr[j], arr[index]);
					}
					else if(min > Math.abs(arr[i] + arr[j] + arr[index])) {
						long sum = arr[i] + arr[j] + arr[index];
						min = Math.abs(sum);
						ans_str = answer(arr[i], arr[j], arr[index]);
					}
				}
			}
		}
		
		System.out.println(ans_str);
	}
	
	public static int search(long num) {
		long find = -num;
		
		int index = Arrays.binarySearch(arr, find);
				
		if(index < 0) {
			index = -index - 1;
			
			if(index == 0) {
				return index;
			}
			
			if(index == N) {
				return index - 1;
			}
			
			long sum1 = arr[index] + num;
			long sum2 = arr[index - 1] + num;
			
			if(Math.abs(sum1) > Math.abs(sum2)) {
				return index - 1;
			}
		}
		
		return index;
	}
	
	public static String answer(long a, long b, long c) {
		long[] arr = {a, b, c};
		
		Arrays.sort(arr);
		
		return arr[0] + " " + arr[1] + " " + arr[2];
	}

}

