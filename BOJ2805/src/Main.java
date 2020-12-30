import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[] wood;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		String[] length = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		wood = new int[n];
		
		for(int i = 0; i < n; i++) 
			wood[i] = Integer.parseInt(length[i]);
		
		Arrays.sort(wood);
		
		long start = 0;
		long end = wood[n - 1];
		long mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(cutWood(mid) >= m) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
	
	public static long cutWood(long length) {
		long value = 0;
		
		for(int i = 0; i < wood.length; i++)
			value += wood[i] - length > 0 ? wood[i] - length : 0;
		
		
		return value;
	}

}
