import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<String> list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				String[] st = br.readLine().split(" ");
				if(!list.contains(st[1])) 
					list.add(st[1]);
				map.put(st[1], map.get(st[1]) == null ? 1 : map.get(st[1]) + 1);
			}
			
			int answer = 1;
			
			for(int i = 0; i < map.size(); i++) {
				answer *= (map.get(list.get(i)) + 1);
			}
			sb.append(answer - 1 + "\n");
		}
		
		System.out.print(sb);
 
	}

}
