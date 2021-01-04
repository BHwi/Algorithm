import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			list.add(tmp);
			arr[i] = tmp;
		}
		
		Collections.sort(list);
		
		int tmp = 0;
		map.put(list.get(0), tmp);
		for(int i = 1; i < N; i++) {
			if(list.get(i) - list.get(i - 1) != 0)
				tmp++;
			
			if(map.get(list.get(i)) == null) 
				map.put(list.get(i), tmp);
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])+ " ");
		}
		
		System.out.println(sb);
	}

}
