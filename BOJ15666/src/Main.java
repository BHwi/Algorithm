import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, Integer> map = new HashMap<>();
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
		
		Arrays.fill(output, -1);
		
		func(output, 0);
		
		System.out.print(sb);
		
	}
	
	public static void func(int[] output, int n) {
		int[] tmp = new int[M];
		
		for(int i = 0; i < tmp.length; i++)
			tmp[i] = output[i];
		
		if(n == M) {
			String str = "";
			
			for(int i = 0; i < tmp.length; i++) {
				str += arr[tmp[i]] + " ";
			}
			
			if(!map.containsKey(str)) {
				map.put(str, 1);
				sb.append(str + "\n");
			}
		}
		else if(n == 0) {
			for(int i = 0; i < N; i++) {
				tmp[n] = i;
				func(tmp, n + 1);
			}
		}
		else {
			for(int i = 0; i < N; i++) {
				if(tmp[n - 1] <= i) {
					tmp[n] = i;
					func(tmp, n + 1);
				}
			}
		}
	}
	
	public static boolean hasNumber(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == n)
				return true;
		}
		return false;
	}

}