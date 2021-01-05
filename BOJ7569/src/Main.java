import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Point> q = new ArrayDeque<>();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][][] arr = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) q.add(new Point(i, j, k, 0));
                }   
            }
        }

        int[] dx = {0, 0, 0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0, 0, 0};
        int[] dz = {0, 0, -1, 1, 0, 0};
        int count = 0;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            visited[p.x][p.y][p.z] = true;

            for(int i = 0; i < 6; i++) {
                int idx = p.x + dx[i];
                int idy = p.y + dy[i];
                int idz = p.z + dz[i];
                
                if(idx >= 0 && idx < H && idy >= 0 && idy < N && idz >= 0 && idz < M) {
                    if(!visited[idx][idy][idz] && arr[idx][idy][idz] == 0) {
                        q.add(new Point(idx, idy, idz, p.count + 1));
                        arr[idx][idy][idz] = 1;
                    }
                }
            }
            if(q.isEmpty()) count = p.count;
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }   
            }
        }

        System.out.println(count);

    }

    public static class Point {
        int x, y, z, count;
        Point(int x, int y, int z, int count) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.count = count;
        }
    }
}
