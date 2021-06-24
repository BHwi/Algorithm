import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int none = 1; // 맨 아래 사자가 없는 경우
		int left = 1; // 맨 아래 사자가 왼쪽에 있는 경우
		int right = 1; // 맨 아래 사자가 오른쪽에 있는 경우
		
		for(int i = 0; i < N - 1; i++) {
			int tmp_n = none;
			int tmp_l = left;
			int tmp_r = right;
			
			none = (tmp_n + tmp_l + tmp_r) % 9901;
			left = (tmp_n + tmp_r) % 9901;
			right = (tmp_n + tmp_l) % 9901;
		}
		
		System.out.println((none + left + right) % 9901);
	}

}
