import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		LinkedList<String>[] list = new LinkedList[51];
		
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			String str = sc.nextLine();
			int l = str.length();
			
			if(list[l] == null) {
				list[l] = new LinkedList<String>();
			}
			
			if(!list[l].contains(str)) list[l].add(str);
		}
		
		for(int i = 0; i < 51; i++) {
			if(list[i] != null) {
				Collections.sort(list[i]);
				
				for(String str : list[i]) 
					System.out.println(str);
				
			}
		}
		
		sc.close();
	}

}
