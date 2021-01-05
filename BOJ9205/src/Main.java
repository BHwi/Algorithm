import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());
            Location[] l = new Location[N + 2];
            boolean[] visited = new boolean[N + 2];
            Deque<Location> q = new ArrayDeque<>();
            boolean b = false;

            for(int i = 0; i < N + 2; i++) {
                String[] str = br.readLine().split(" ");
                l[i] = new Location(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            q.add(l[0]);

            while(!q.isEmpty()) {
                Location now = q.poll();

                if(now.equals(l[N + 1])) {
                    b = true;
                    break;
                }

                for(int i = 1; i < N + 2; i++) {
                    if(!visited[i] && Math.abs(now.x - l[i].x) + Math.abs(now.y - l[i].y) <= 1000) {
                        q.add(l[i]);
                        visited[i] = true;
                    }
                }
            }
            if(b) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.print(sb);

    }

    public static class Location {
        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
