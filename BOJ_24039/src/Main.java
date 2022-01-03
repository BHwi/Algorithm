import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	
	public static ArrayList<Integer> list = new ArrayList<>();
	public static HashSet<Integer> mullist = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = stoi(br.readLine()) + 1;
		prime();
		
		for(int i = 0; i < list.size() - 1; i++) {
			mullist.add(list.get(i) * list.get(i + 1));
		}
		
		while(!mullist.contains(N)) {
			N++;
		}
		
		System.out.println(N);
	}
	
	public static void prime() {
		list.add(2);
		
		for(int i = 3; i < 10000; i++) {
			if(i % 2 != 0) {
				boolean b = true;
				for(int j = 3; j <= Math.sqrt(i); j += 2) {
					if(i % j == 0) {
						b = false;
					}
				}
				
				if(b) list.add(i);
			}
		}
	}
}
