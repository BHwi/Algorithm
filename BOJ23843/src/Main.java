import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static int answer = 0;
	public static int[] time, socket;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		time = new int[N];
		socket = new int[M];
		
		for(int i = 0; i < N; i++) time[i] = stoi(st.nextToken());
		Arrays.sort(time);
		
		if(M == 1) {
			for(int i = 0; i < N; i++) answer += time[i];
			System.out.println(answer);
			System.exit(0);
		}
		
		for(int i = N - 1; i >= 0; i--) {
			if(isEmpty()) {
				for(int j = 0; j < M; j++) {
					if(socket[j] == 0) {
						socket[j] = time[i];
						break;
					}
				}
			}
			if(!isEmpty()) {
				optimize();
			}
		}
		
		int max = 0;
		for(int i = 0; i < M; i++) {
			max = Math.max(socket[i], max);
		}
		
		System.out.println(answer + max);
	}
	
	public static boolean isEmpty() {
		for(int i = 0; i < socket.length; i++) {
			if(socket[i] == 0) return true;
		}
		return false;
	}

	public static void optimize() {
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < socket.length; i++) {
			min = Math.min(min, socket[i]);
		}
		
		for(int i = 0; i < socket.length; i++) {
			socket[i] -= min;
		}
		
		answer += min;
	}
	
	public static void print() {
		for(int i = 0; i < socket.length; i++)
			System.out.print(socket[i] + " ");
		
		System.out.println();
	}
}
