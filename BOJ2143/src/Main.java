import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static long T, ans = 0, arr1[], arr2[];
	public static HashMap<Long, Integer> m;
	public static ArrayList<Long> list1, list2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		N = Integer.parseInt(br.readLine());
		arr1 = new long[N + 1];
		list1 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N + 1; i++) {
			if (i == 0)
				arr1[i] = 0;
			else if (i == 1)
				arr1[i] = Integer.parseInt(st.nextToken());
			else
				arr1[i] = arr1[i - 1] + Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		arr2 = new long[M + 1];
		list2 = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M + 1; i++) {
			if (i == 0)
				arr1[i] = 0;
			else if (i == 1)
				arr2[i] = Integer.parseInt(st.nextToken());
			else
				arr2[i] = arr2[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < i; j++) {
				list1.add(arr1[i] - arr1[j]);
			}
		}

		long[] dp1 = new long[list1.size()];

		for (int i = 0; i < dp1.length; i++) {
			dp1[i] = list1.get(i);
		}

		m = new HashMap<>();
		
		for (int i = 0; i < M + 1; i++) {
			for (int j = 0; j < i; j++) {
				long tmp = arr2[i] - arr2[j];
				
				list2.add(tmp);
				if(m.get(tmp) == null) {
					m.put(tmp, 1);
				}
				else {
					m.put(tmp, m.get(tmp) + 1);
				}
			}
		}

		Collections.sort(list2);

		long[] dp = new long[list2.size()];

		for (int i = 0; i < dp.length; i++) {
			dp[i] = list2.get(i);
		}

		for (int i = 0; i < list1.size(); i++) {
			if (Arrays.binarySearch(dp, T - dp1[i]) < 0) 
				continue;
			else {
				long tmp = T - dp1[i];
				ans += m.get(tmp);
			}

		}

		System.out.println(ans);
	}

}
