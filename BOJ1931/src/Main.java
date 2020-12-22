import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), cont = 0;
		
		List<Conf> conf = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			conf.add(new Conf(start, end));
		}
		
		Collections.sort(conf);
		
		int start = conf.get(0).end;
		cont++;
		
		for(int i = 1; i < n; i++) {
			if(start > conf.get(i).start) continue;
			else {
				cont++;
				start = conf.get(i).end;
			}
		}
		
		System.out.println(cont);
		
	}
	
	public static class Conf implements Comparable<Conf>{
		int start, end;
		
		Conf(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Conf o) {
			if(this.end != o.end)
				return this.end - o.end;
			else 
				return this.start - o.start;
		}
	}
}
