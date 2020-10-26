import java.util.Scanner;

public class Main {
	public static int n, m, near = -100000;
	public static int[] button;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		button = new int[10];
		
		for(int i = 0; i < m; i++) {
			int k = sc.nextInt();
			button[k] = 1;
		}
		
		if(n == 100) {
			System.out.println(0);
			System.exit(0);
		}
		
		for(int i = 0; i < 1000000; i++) {
			if(check(i)) {
				if((n - i >= 0 ? n - i : i - n) < (n - near >= 0 ? n - near : near - n)) {
					near = i;
				}
			}
		}
		
		if(near == n) {
			System.out.println((n - near >= 0 ? n - near : near - n));
		} else {
			System.out.println((n - near >= 0 ? n - near : near - n) + (int) (Math.log10(near)) + 1);
		}
	}
	
	// 고장난게 1, 멀쩡한게 0
	public static boolean check(int value) {
		// 필요한게 1, 안필요한게 0
		int[] need = new int[10];
		
		if(value == 0) {
			need[0] = 1;
		} else {
			while(value != 0) {
				need[value % 10] = 1;
				value /= 10;
			}
		}
		
		for(int i = 0; i < 10; i++) {
			if(need[i] * button[i] == 1)
				return false;
		}
		
		return true;
	}

}
