import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static class Node {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[10][10];
		
		HashMap<String, Node[]> m = new HashMap<>();
		makeSet(m);
		
		int x1 = 10, x2 = -1, y1 = 10, y2 = -1;
		
		for(int i = 0; i < 10; i++) {
			String s = br.readLine();
			
			for(int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt("" + s.charAt(j));
				if(arr[i][j] == 1) {
					x1 = Math.min(x1, i);
					x2 = Math.max(x2, i);
					y1 = Math.min(y1, j);
					y2 = Math.max(y2, j);
				}
			}
		}
		int[][] tmp = new int[x2 - x1 + 1][y2 - y1 + 1];
		
		for(int x = x1; x <= x2; x++) {
			for(int y = y1; y <= y2; y++) {
				tmp[x - x1][y - y1] = arr[x][y];
			}
		}
		
		String answer = toString(tmp);
		
		if(m.containsKey(answer)) {
			Node[] node = m.get(answer);
			System.out.println((node[0].x + x1 + 1) + " " + (node[0].y + y1 + 1) + "\n" +
							   (node[1].x + x1 + 1) + " " + (node[1].y + y1 + 1) + "\n" +
							   (node[2].x + x1 + 1) + " " + (node[2].y + y1 + 1));
		}
		else {
			System.out.println(0);
		}
	}
	
	public static void makeSet(HashMap<String, Node[]> m) {
		// case 1
		for(int N = 2; N <= 10; N++) {
			Node[] node = new Node[3];
			int[][] arr = new int[N][N];
			
			// case 1 - 1
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N - i; j++) {
					arr[i][j] = 1;
				}
			}
			node[0] = new Node(0, 0);
			node[1] = new Node(0, N - 1);
			node[2] = new Node(N - 1, 0);
			
			m.put(toString(arr), node);
			
			node = new Node[3];
			
			for(int i = 0; i < 3; i++) {
				arr = rotate(arr);
				node = new Node[3];
				
				if(i == 0) {
					node[0] = new Node(0, 0);
					node[1] = new Node(N - 1, 0);
					node[2] = new Node(N - 1, N - 1);
				}
				else if(i == 1) {
					node[0] = new Node(0, N - 1);
					node[1] = new Node(N - 1, 0);
					node[2] = new Node(N - 1, N - 1);
				}
				else if(i == 2) {
					node[0] = new Node(0, 0);
					node[1] = new Node(0, N - 1);
					node[2] = new Node(N - 1, N - 1);
				}
				
				m.put(toString(arr), node);
			}
		}
		
		// case 2
		for(int N = 3; N <= 9; N += 2) {
			Node[] node = new Node[3];
			int[][] arr = new int[N][N / 2 + 1];
			
			for(int i = 0; i < N; i++) {
				if(i < N / 2) {
					for(int j = 0; j <= i; j++) {
						arr[i][j] = 1;
					}
				}
				else {
					for(int j = 0; j < N - i; j++) {
						arr[i][j] = 1;
					}
				}
			}
			node[0] = new Node(0, 0);
			node[1] = new Node(N / 2, N / 2);
			node[2] = new Node(N - 1, 0);
			m.put(toString(arr), node);
			
			for(int i = 0; i < 3; i++) {
				node = new Node[3];
				arr = rotate(arr);
				
				if(i == 0) {
					node[0] = new Node(0, N / 2);
					node[1] = new Node(N / 2, 0);
					node[2] = new Node(N / 2, N - 1);
				}
				else if(i == 1) {
					node[0] = new Node(0, N / 2);
					node[1] = new Node(N / 2, 0);
					node[2] = new Node(N - 1, N / 2);
				}
				else if(i == 2) {
					node[0] = new Node(0, 0);
					node[1] = new Node(0, N - 1);
					node[2] = new Node(N / 2, N / 2);
				}
				m.put(toString(arr), node);
			}
		}
	}
	
	public static int[][] rotate(int[][] arr) {
		int[][] returnArr = new int[arr[0].length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				returnArr[arr[0].length - 1 - j][i] = arr[i][j];
			}
		}
		
		return returnArr;
		
	}
	
	public static String toString(int[][] arr) {
		String str = "";
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				str += arr[i][j];
			}
			str += "\n";
		}
		
		return str;
	}
}
