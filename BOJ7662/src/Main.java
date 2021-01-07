import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        
        while(T --> 0) {
            int N = Integer.parseInt(br.readLine());
            TreeMap<Long, Long> map = new TreeMap<>();

            while(N --> 0) {
                String[] input = br.readLine().split(" ");
                char command = input[0].charAt(0);
                long number = Long.parseLong(input[1]);

                if(command == 'I') {
                    if(map.containsKey(number)) map.put(number, map.get(number) + 1);
                    else map.put(number, 1L);
                }
                else {
                    if(map.isEmpty()) continue;
                    if(number == 1) {
                        long key = map.lastKey();
                        long next = map.get(key) - 1;
                        if(next == 0)
                            map.remove(key);
                        else
                            map.put(key, next);
                    }
                    else {
                        long key = map.firstKey();
                        long next = map.get(key) - 1;
                        if(next == 0)
                            map.remove(key);
                        else
                            map.put(key, next);
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey() + " " + map.firstKey() + "\n");
        }

        System.out.print(sb);
    }
}
