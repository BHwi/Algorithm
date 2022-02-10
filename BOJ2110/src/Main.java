import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = stoi(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[arr.length - 1];
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(f(mid, arr) < M) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		
		System.out.println(start - 1);
		
	}
	
	public static int f(int distance, int[] arr) {
		int ret = 1;
		int cur = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - cur >= distance) {
				ret++;
				cur = arr[i];
			}
		}
		
		return ret;
	}

}
