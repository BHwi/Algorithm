import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<NewInteger> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll().value + "\n");
            }
            else {
                pq.add(new NewInteger(input));
            }
        }
        System.out.print(sb);
    }

    public static class NewInteger implements Comparable<NewInteger> {
        int value;

        NewInteger(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(NewInteger o) {
            int i = Math.abs(this.value) - Math.abs(o.value);
            if(i != 0) return i;
            else return this.value - o.value;
        }
    }
}
