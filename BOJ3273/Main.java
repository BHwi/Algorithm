import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> s = new HashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			s.add(tmp);
			arr[i] = tmp;
		}
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			if(s.contains(arr[i])) {
				s.remove(arr[i]);
				if(s.contains(X - arr[i])) {
					answer++;
					s.remove(X - arr[i]);
				}
			}
		}
		
		System.out.println(answer);

	}

}
