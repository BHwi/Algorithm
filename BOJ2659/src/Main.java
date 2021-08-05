import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static HashMap<Integer, Integer> m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = new HashMap<>();
		
		makeMap();
		
		String s = "";
		
		while(st.hasMoreTokens()) s += st.nextToken();
		
		int min = 10000;
		
		for(int j = 0; j < 4; j++) {
			int num = Integer.parseInt("" + s.charAt(j % 4) + s.charAt((j + 1) % 4) + s.charAt((j + 2) % 4) + s.charAt((j + 3) % 4));
			min = Math.min(min, num);
		}
		
		System.out.println(m.get(min));
	}
	
	public static void makeMap() {
		int order = 1;
		
		for(int i = 1111; i < 10000; i++) {
			if(hasZero(i)) continue;
			
			String s = "" + i;
			int min = 10000;
			
			for(int j = 0; j < 4; j++) {
				int num = Integer.parseInt("" + s.charAt(j % 4) + s.charAt((j + 1) % 4) + s.charAt((j + 2) % 4) + s.charAt((j + 3) % 4));
				min = Math.min(min, num);
			}
			
			if(m.containsKey(min)) {
				continue;
			}
			else {
				m.put(min, order++);
			}
		}
	}
	
	public static boolean hasZero(int num) {
		String s = "" + num;
		
		if(s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0' || s.charAt(3) == '0')
			return true;
		
		return false;
	}

}
