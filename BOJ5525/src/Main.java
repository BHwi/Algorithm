import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split("");
		int[] hash = new int[m];
		int tmp = 0;
		for (int i = 0; i < m; ++i) {
			if (str[i].equals("I")) {
				hash[tmp] = i;
				tmp++;
			}
		}
		int cnt = 0;
		int answer = 0;
		for (int i = 1; i < tmp; ++i) {
			if (hash[i] - hash[i - 1] == 2) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt >= n) {
				answer++;
			}
		}
		bw.write("" + answer + "\n");
	}

}