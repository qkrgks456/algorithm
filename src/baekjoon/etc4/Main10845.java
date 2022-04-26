package baekjoon.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10845 {
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String s = stringTokenizer.nextToken();
            switch (s) {
                case "push":
                    int num = Integer.parseInt(stringTokenizer.nextToken());
                    push(num);
                    break;
                case "pop":
                    stringBuilder.append(pop() + "\n");
                    break;
                case "size":
                    stringBuilder.append(size() + "\n");
                    break;
                case "empty":
                    stringBuilder.append(empty() + "\n");
                    break;
                case "front":
                    stringBuilder.append(front() + "\n");
                    break;
                case "back":
                    stringBuilder.append(back() + "\n");
                    break;
            }
        }
        System.out.println(stringBuilder);
    }

    public static void push(int n) {
        list.add(n);
    }

    public static int pop() {
        if (list.size() == 0) {
            return -1;
        } else {
            return list.remove(0);
        }
    }

    public static int size() {
        return list.size();
    }

    public static int empty() {
        if (list.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (list.size() == 0) {
            return -1;
        } else {
            return list.get(0);
        }
    }

    public static int back() {
        if (list.size() == 0) {
            return -1;
        } else {
            return list.get(list.size() - 1);
        }
    }
}
