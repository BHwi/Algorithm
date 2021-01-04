import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		for (int i = 0; i < T; i++) {
			int answer = 0;
			int M = in.nextInt();
			int N = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			
			int max = M*N;
			int index = 0;
			
			if(y == N)
				y = 0;
			
			while(true) {
				if((M*index + x) %  N == y) {
					answer = M*index + x;
					break;
				}
				
				if(M*index + x > max) {
					answer = -1;
					break;
				}
				index++;
			}
			
				
			
			System.out.println(answer);
		}
	}
}