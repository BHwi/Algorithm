import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] arr, output;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		output = new int[M];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		func(0);
		
		System.out.print(sb);
		
	}
	
	public static void func(int n) {
		if(n == M) {
			for(int i = 0; i < output.length; i++) {
				sb.append(arr[output[i]] + " ");
			}
			sb.append("\n");
		}
		else if(n == 0) {
			for(int i = 0; i < N; i++) {
				output[n] = i;
				func(n + 1);
			}
		}
		else {
			for(int i = 0; i < N; i++) {
					output[n] = i;
					func(n + 1);
			}
		}
	}
	
	public static boolean hasNumber(int n) {
		for(int i = 0; i < output.length; i++) {
			if(output[i] == n)
				return true;
		}
		return false;
	}

}
