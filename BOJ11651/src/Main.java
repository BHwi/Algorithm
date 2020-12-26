import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Arr> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			list.add(new Arr(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < n; i++) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.print(sb);

	}
	
	public static class Arr implements Comparable<Arr>{
		int x, y;
		
		Arr(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Arr o) {
			if(this.y != o.y)
				return this.y - o.y;
			else 
				return this.x - o.x;
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
		
	}

}
