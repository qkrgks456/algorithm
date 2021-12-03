package inflearn.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        String[] strings = str1.split("");
        String[] strings1 = str2.split("");
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        for (String s : strings1) {
            for (int i = 0; i < strings.length; i++) {
                if (s.equals(strings[i])) {
                    count++;
                }
            }
            queue.add(s);
        }
        if (count == str1.length()) {
            while (str1.length() != queue.size()) {
                String st = queue.poll();
                if (str1.contains(st)) {
                    queue.add(st);
                }
            }
            String result = "";
            for (String s : queue) {
                result += s;
            }
            if (str1.equals(result)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
    }
}
