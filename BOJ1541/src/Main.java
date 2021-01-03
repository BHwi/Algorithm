import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input = br.readLine();

		String num = "";
		int sum = 0, i = 0;
		boolean b = false; // -를 할 수 있으면 true, -를 할 수 없으면 false

		for (i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '+' || ch == '-') {
				break;
			} else {
				num += ch;
			}
		}
		
		sum += Integer.parseInt(num);
		num = "";

		for (; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if (ch == '+') {
				for(i = i + 1; i < input.length(); i++) {
					if(input.charAt(i) == '+' || input.charAt(i) == '-') {
						i--;
						break;
					}
					num += input.charAt(i);
				}
				if(b) {
					sum -= Integer.parseInt(num);
				}
				else {
					sum += Integer.parseInt(num);
				}
				num = "";
			} 
			else if (ch == '-') {
				for(i = i + 1; i < input.length(); i++) {
					if(input.charAt(i) == '+' || input.charAt(i) == '-') {
						i--;
						break;
					}
					num += input.charAt(i);
				}
				sum -= Integer.parseInt(num);
				b = true;
				num = "";
			}
		}

		System.out.print(sum);

	}

}
