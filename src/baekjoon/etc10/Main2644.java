package baekjoon.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2644 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n1 = Integer.parseInt(stringTokenizer.nextToken());
        int n2 = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] ch = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }
        Queue<Integer> queue = new LinkedList<>();
        ch[n1] = 1;
        queue.add(n1);
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == n2) {
                    System.out.println(level);
                    System.exit(0);
                }
                for (int num : list.get(poll)) {
                    if (ch[num] == 0) {
                        ch[num] = 1;
                        queue.add(num);
                    }
                }
            }
        }
        System.out.println(-1);
    }

}
