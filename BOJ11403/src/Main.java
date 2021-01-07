import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N];

        for(int i = 0; i < N; i++)
            list[i] = new ArrayList<Integer>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    list[i].add(j);
            }
        }

        for(int i = 0; i < N; i++) {
            int[] visited = new int[N];
            Deque<Integer> q = new ArrayDeque<>();

            q.add(i);

            while(!q.isEmpty()) {
                int now = q.poll();

                Iterator<Integer> itr = list[now].iterator();

                while(itr.hasNext()) {
                    int next = itr.next();
                    if(visited[next] == 0) {
                        q.add(next);
                        visited[next] = 1;
                    }
                }
            }

            for(int j = 0; j < N; j++)
                sb.append(visited[j] + " ");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
