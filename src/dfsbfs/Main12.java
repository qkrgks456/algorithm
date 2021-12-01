package dfsbfs;

import java.util.*;

public class Main12 {
    static int n1 = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> list;
    static int[] dis;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i <= n1; i++) {
            list.add(new ArrayList<>());
        }
        ch = new int[n1 + 1];
        dis = new int[n1 + 1];
        for (int i = 0; i < n2; i++) {
            int n3 = scanner.nextInt();
            int n4 = scanner.nextInt();
            list.get(n3).add(n4);
        }
        BFS(1);
        for (int i = 2; i < dis.length; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        ch[num] = 1;
        queue.add(num);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int n : list.get(poll)) {
                if (ch[n] == 0) {
                    queue.add(n);
                    ch[n] = 1;
                    dis[n] = dis[poll] + 1;
                }
            }
        }
    }
}
