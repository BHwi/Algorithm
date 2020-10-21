import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

		System.out.println(pow(a, b, c));
	}

	public static long pow(long a, long b, long c) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a % c;
		} else if (b % 2 == 0) {
			long temp = pow(a, b / 2, c);
			return (temp * temp) % c;
		} else {
			long temp = pow(a, b - 1, c);
			return (a * temp) % c;
		}
	}

}
