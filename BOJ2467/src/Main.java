import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static boolean is_Zero = false;
	public static int N;
	public static long arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			long num = Integer.parseInt(st.nextToken());

			if (num == 0) {
				if (!is_Zero)
					is_Zero = true;
				else {
					System.out.println("0 0");
					System.exit(0);
				}
			}
			
			arr[i] = num;
		}

		String ans_str = "";
		long min = 2_000_000_001;

		for (int i = 0; i < arr.length; i++) {
			long num1 = arr[i];
			long num2;

			int p_index = Arrays.binarySearch(arr, -num1);

			if (p_index < 0) {
				p_index = -p_index - 1;

				if (p_index == arr.length) {
					p_index = p_index - 1;
				} else {
					if (p_index > 0) {
						if (Math.abs(num1 + arr[p_index]) > Math.abs(num1 + arr[p_index - 1])) {
							p_index -= 1;
						}
					}
				}
			}
			
			if(p_index == i) continue;
			
			num2 = arr[p_index];
			
			if (Math.abs(num1 + num2) < min) {
				min = Math.min(min, Math.abs(num1 + num2));
				if(num1 < num2) ans_str = num1 + " " + num2;
				else ans_str = num2 + " " + num1;
			}

		}

		System.out.println(ans_str);
	}

}

