import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] set = new int[21];
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			
			if(input[0].equals("add")) {
				set[Integer.parseInt(input[1])] = 1;
			}
			else if(input[0].equals("remove")) {
				set[Integer.parseInt(input[1])] = 0;
			}
			else if(input[0].equals("check")) {
				if(set[Integer.parseInt(input[1])] == 1)
					sb.append("1\n");
				else 
					sb.append("0\n");
			}
			else if(input[0].equals("toggle")) {
				int toggle = Integer.parseInt(input[1]);
				set[toggle] = set[toggle] == 0 ? 1 : 0;
			}
			else if(input[0].equals("all")) {
				Arrays.fill(set, 1);
			}
			else if(input[0].equals("empty")) {
				Arrays.fill(set, 0);
			}
		}
		
		System.out.print(sb);
		
	}

}
