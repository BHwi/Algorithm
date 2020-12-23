import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int value = sc.nextInt();
		String str = "";
		
		while(value != 0) {
			if(isPalindrome(value))
				str += "yes\n";
			else 
				str += "no\n";
			value = sc.nextInt();
		}
		
		System.out.println(str);

	}
	
	public static boolean isPalindrome(int value) {
		String str = Integer.toString(value);
		
		for(int i = 0; i < str.length() / 2; i++) {
			if(str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}
		return true;
	}

}
