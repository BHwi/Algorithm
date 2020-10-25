import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long min = sc.nextLong(), max = sc.nextLong();
		int n = (int) (max - min + 1), count = 0;
		boolean[] arr = new boolean[n];
		
		for(long i = 2; i * i <= max; i++) {
			long a = min / (i * i);
			long b = max / (i * i);
			
			if(min % (i * i) == 0) {
				for(long j = a; j <= b; j++) {
					arr[(int)(i * i * j - min)] = true;
				}
			}
			else {
				for(long j = a + 1; j <= b; j++) {
					arr[(int)(i * i * j - min)] = true;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
			if(!arr[i]) count++;
		
		System.out.println(count);
	}

}
