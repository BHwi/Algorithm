import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		while(N --> 0) {
			String[] str = br.readLine().split(" ");
			int[] input = new int[str.length];
			
			for(int i = 0; i < str.length; i++) input[i] = Integer.parseInt(str[i]);
			
			sb.append(ans(input[0], input[1], input[2], input[3]) + "\n");
		}
		
		System.out.print(sb);
		
	}
	
	public static long ans(int M, int N, int x, int y) {
		int i = 0;
		if(y == N) y = 0;
		
		while(M * i + x <= LCM(M, N)) {
			if((M * i + x) % N == y)
				return M * i + x;
			i++;
		}
		
		return -1;
	}
	
	public static long GCD(int x, int y) {
		if(y == 0)
			return x;
		else 
			return GCD(y, x % y);
	}
	
	public static long LCM(int x, int y) {
		return x * y / GCD(x, y);
	}

}
