import java.util.Scanner;

public class Main {
	public static final long M = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long result = 0;
		
		sc.nextLine();
		
		String str = sc.nextLine();

		for(int i = 0; i < n; i++) {
			result = (result + hash(str.charAt(i), i)) % M;
		}
		
		System.out.println(result);

	}
	
	public static long hash(char ch, int multiple) {
		long value = (int) ch - 96;
		
		for(int i = 0; i < multiple; i++) {
			value = (value * 31) % M;
		}
		
		return value;
	}

}
