package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main01 {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            if (s.contains("push")) {
                String[] strings = s.split(" ");
                push(Integer.parseInt(strings[1]));
            } else if (s.equals("pop")) {
                System.out.println(pop());
            } else if (s.equals("size")) {
                System.out.println(size());
            } else if (s.equals("empty")) {
                System.out.println(empty());
            } else if (s.equals("top")) {
                System.out.println(top());
            }
        }
    }

    public static void push(int num) {
        list.add(num);
    }

    public static int pop() {
        if (list.size() > 0) {
            int num = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return num;
        } else {
            return -1;
        }
    }

    public static int size() {
        return list.size();
    }

    public static int empty() {
        if (list.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int top() {
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        } else {
            return -1;
        }
    }
}
