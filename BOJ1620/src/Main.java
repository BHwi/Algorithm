import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] arr = new String[N + 1];
		
		for(int i = 1; i <= N; i++) {
			String name = br.readLine();
			map.put(name, i);
			arr[i] = name;
		}
		
		for(int i = 0; i < M; i++) {
			String answer = br.readLine();
			if(answer.charAt(0) >= 'A' && answer.charAt(0) <= 'Z')
				sb.append(map.get(answer));
			else
				sb.append(arr[Integer.parseInt(answer)]);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
