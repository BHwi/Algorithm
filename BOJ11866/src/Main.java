import java.io.*;

public class Main {
	public static boolean[] arr;
	public static int n, k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] st = br.readLine().split(" ");
		
		n = Integer.parseInt(st[0]);
		k = Integer.parseInt(st[1]);
		arr = new boolean[n + 1];
		arr[0] = true;
		
		sb.append("<");
		
		int now = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				now = move(now);
			}
			arr[now] = true;
			if(i != n - 1) sb.append((now) + ", ");
			else sb.append((now) + ">");
		}
		
		System.out.println(sb);
	}
	
	public static int move(int now) {
		while(arr[now + 1 <= n ? now + 1 : 1]) {
			now = now + 1 <= n ? now + 1 : 1;
		}
		
		return now + 1 <= n ? now + 1 : 1;
	}

}
