import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = stoi(br.readLine());
		
		for(int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine());
			int N = stoi(st.nextToken());
			int M = stoi(st.nextToken());
			
			while(M --> 0) br.readLine();
			
			System.out.println(N - 1);
		}
	}
}
