import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(GCD(a, b));
		System.out.println(LCM(a, b));

	}
	
	public static int GCD(int a, int b) {
		int big = a > b ? a : b;
		int small = a < b ? a : b;
		int value;
		
		while(big % small != 0) {
			value = big % small;
			big = small;
			small = value;
		}
		
		return small;
	}
	
	public static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}
}
