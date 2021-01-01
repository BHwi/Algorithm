import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		BigInteger number = new BigInteger("1");
		
		for(int i = 1; i <= n; i++) {
			number = number.multiply(new BigInteger(Integer.toString(i)));
		}
		
		String str = number.toString();
		int count = 0;
		
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) != '0') break;
			else count++;
		}
		
		System.out.println(count);

	}

}
