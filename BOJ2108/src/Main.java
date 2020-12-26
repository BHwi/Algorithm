import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int n, sum, max = -4001, min = 4001, mode;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Mode> list2 = new ArrayList<>();
		int[] arr_count = new int[8001];

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
			sum += tmp;
			max = Math.max(tmp, max);
			min = Math.min(tmp, min);
			arr_count[tmp + 4000] += 1;
		}

		for (int i = 0; i < arr_count.length; i++) {
			if(arr_count[i] != 0) list2.add(new Mode(i, arr_count[i]));
		}

		Collections.sort(list);
		Collections.sort(list2);
		
//		for(int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i));
//		}
		
		if(n == 1) 
			mode = list2.get(0).number;
		else {
			if(list2.get(0).count != list2.get(1).count) mode = list2.get(0).number;
			else mode = list2.get(1).number;
		}

		System.out.println(Math.round((double) sum / n));
		System.out.println(list.get(n / 2));
		System.out.println(mode - 4000);
		System.out.println(max - min);

	}

	public static class Mode implements Comparable<Mode> {
		int number, count;

		Mode(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Mode o) {
			if (this.count != o.count)
				return o.count - this.count;
			else
				return this.number - o.number;
		}
		
		@Override
		public String toString() {
			return number - 4000 + " " + count;
		}
	}

}
