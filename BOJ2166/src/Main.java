import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static double stod(String s) {return Double.parseDouble(s);}
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Point {
		double x, y;
		Point(double x, double y) {this.x = x; this.y = y;}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = stoi(br.readLine());
		Point[] p = new Point[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			p[i] = new Point(stod(st.nextToken()), stod(st.nextToken()));
		}
		
		double result = 0;
		
		for(int i = 1; i < n; i++) {
			result += ccw(p[0].x, p[i - 1].x, p[i].x, p[0].y, p[i - 1].y, p[i].y);
		}
		
		System.out.printf("%.1f",Math.abs(result));
	}
	
	public static double ccw(double x1, double x2, double x3, double y1, double y2, double y3) {
		return ((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)) / 2;
	}

}
