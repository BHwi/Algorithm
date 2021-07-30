import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int i = N;
		long count = 0;
		
		while(i > 0) {
			System.out.print("i : " + i + ", count : " + count);
			if(gauss(N, i) == gauss(N, i + 1)) {
				count += (gauss(N, i));
				System.out.println(" count += " + (gauss(N, i)));
				i--;
			}
			else {
				int end = gauss(N, gauss(N, i));
				
				System.out.println(" count += " + ((i - end + 1) * gauss(N, i)));
				
				count += ((i - end + 1) * gauss(N, i));
				
				i = end - 1;
			}
		}
		
		System.out.println(count);
	}
	
	public static int gauss(int a, int b) {
		if(a % b == 0) {
			return a / b;
		}
		else {
			return a / b + 1;
		}
	}
}
