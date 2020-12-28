import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static final int M = 10000000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] arr = new int[20000001];
		int n = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(line[i]) + M]++;
		}
		
		n = Integer.parseInt(br.readLine());
		int[] arr2 = new int[n];
		
		line = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			arr2[i] = Integer.parseInt(line[i]) + M;
		}

		for(int i = 0; i < n; i++) {
			sb.append((arr[arr2[i]]) + " ");
		}
		
		System.out.print(sb);

	}

}
