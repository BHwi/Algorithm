import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long count = 0;
		
		for(int i = 1; i <= N; i++) {
			long tmp_count = 0;
			for(int j = 1; j <= N; j += i) {
				tmp_count++;
			}
			System.out.println("i : " + i + ", count : " + tmp_count);
			count += tmp_count;
		}
		
		System.out.println(count);
	}

}
