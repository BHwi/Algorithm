import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<String> s = new HashSet<>();
		
		int A = stoi(st.nextToken());
		int B = stoi(st.nextToken());
		int overlap = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A; i++) s.add(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < B; i++) if(s.contains(st.nextToken())) overlap++;
		
		System.out.println(A + B - overlap * 2);
	}
}
