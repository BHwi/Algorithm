import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < N; i++) 
			map.put(br.readLine(), i);
		
		int count = 0;
		List<String> list = new ArrayList<String>();
		
		while(M --> 0) {
			String find = br.readLine();
			if(map.get(find) != null) {
				list.add(find);
				count++;
			}
		}
		
		Collections.sort(list);
		
		sb.append(count + "\n");
		
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			sb.append(itr.next() + "\n");
		}
		
		System.out.print(sb);
	}

}

