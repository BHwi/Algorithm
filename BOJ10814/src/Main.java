import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Account> acc = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			acc.add(new Account(age, name, i));
		}
		
		Collections.sort(acc);
		
		for(int i = 0; i < n; i++) {
			System.out.println(acc.get(i));
		}
		
		
	}
	
	public static class Account implements Comparable<Account>{
		int age, order; 
		String name;
		
		public Account(int age, String name, int order) {
			this.age = age;
			this.name = name;
			this.order = order;
		}
		
		@Override
		public int compareTo(Account o) {
			if(this.age != o.age)
				return this.age - o.age;
			else 
				return this.order - o.order;
		}
		
		@Override
		public String toString() {
			return this.age + " " + this.name;
		}
	}

}
