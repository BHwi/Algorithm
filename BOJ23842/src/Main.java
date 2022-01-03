import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = stoi(br.readLine()) - 4;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				for(int k = 0; k < 100; k++) {
					if(i + j == k && count(i) + count(j) + count(k) == N) {
						print(i, j, k);
						return;
					}
				}
			}
		}
		System.out.println("impossible");
	}
	
	public static void print(int i, int j, int k) {
		if(i < 10) System.out.print("0" + i);
		else System.out.print(i);
		System.out.print("+");
		
		if(j < 10) System.out.print("0" + j);
		else System.out.print(j);
		System.out.print("=");
		
		if(k < 10) System.out.print("0" + k);
		else System.out.print(k);
		System.out.println();
	}
	
	public static int count(int i) {
		int[] num = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
		return num[i / 10] + num[i % 10];
	}

}
