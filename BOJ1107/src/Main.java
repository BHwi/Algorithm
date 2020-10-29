import java.util.Scanner;

public class Main {
	public static int n, m, near = -100000;
	public static int[] button;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		int min = Math.abs(n - 100);

		button = new int[10];

		for(int i = 0; i < m; i++) {
			int k = sc.nextInt();
			button[k] = 1;
		}

		for(int i = 0; i < 1000000; i++) {
			int length = len(i);
			
			if(length > 0) min = Math.min(min, Math.abs(n - i) + length);
		}
		
		System.out.println(min);
	}
	
	public static int len(int i) {
		// length가 0 이면 만들 수 없음을 의미.
		// 따라서 length가 0 이상 이면 위와 같이 min을 계산.
		int length = 0;
		
		if(i == 0) return button[i] == 1 ? 0 : 1;
		
		// i의 끝 자리수를 파악한 뒤, i를 10을 나누어서 0이 될때까지 자릿수가 있는지 확인
		while(i > 0) {
			// 자릿수가 고장났을 경우 0을 반환
			if(button[i % 10] == 1) return 0;
			
			length++;
			i /= 10;
		}
		
		return length;
	}

}
