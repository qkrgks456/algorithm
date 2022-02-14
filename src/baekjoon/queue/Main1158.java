package baekjoon.queue;

import java.util.*;

public class Main1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            if (count == k) {
                count = 0;
                list.add(num);
            } else {
                queue.add(num);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                stringBuilder.append(list.get(i));
            } else {
                stringBuilder.append(list.get(i) + ", ");
            }
        }
        stringBuilder.append(">");
        System.out.println(stringBuilder);
    }
}
