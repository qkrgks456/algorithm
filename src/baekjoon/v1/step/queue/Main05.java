package baekjoon.v1.step.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main05 {
    public static void main(String[] args) throws Exception {
        String[] strings;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            if (s.contains("push_front")) {
                strings = s.split(" ");
                list.add(0, Integer.parseInt(strings[1]));
            } else if (s.contains("push_back")) {
                strings = s.split(" ");
                list.add(Integer.parseInt(strings[1]));
            } else if (s.equals("pop_front")) {
                if (!list.isEmpty()) {
                    stringBuilder.append(String.valueOf(list.get(0)) + "\n");
                    list.remove(0);
                } else {
                    stringBuilder.append(String.valueOf(-1) + "\n");
                }
            } else if (s.equals("pop_back")) {
                if (!list.isEmpty()) {
                    stringBuilder.append(String.valueOf(list.get(list.size() - 1)) + "\n");
                    list.remove(list.size() - 1);
                } else {
                    stringBuilder.append(String.valueOf(-1) + "\n");
                }
            } else if (s.equals("size")) {
                stringBuilder.append(String.valueOf(list.size()) + "\n");
            } else if (s.equals("empty")) {
                if (list.isEmpty()) {
                    stringBuilder.append(String.valueOf(1) + "\n");
                } else {
                    stringBuilder.append(String.valueOf(0) + "\n");
                }
            } else if (s.equals("front")) {
                if (!list.isEmpty()) {
                    stringBuilder.append(String.valueOf(list.get(0)) + "\n");
                } else {
                    stringBuilder.append(String.valueOf(-1) + "\n");
                }
            } else if (s.equals("back")) {
                if (!list.isEmpty()) {
                    stringBuilder.append(String.valueOf(list.get(list.size() - 1)) + "\n");
                } else {
                    stringBuilder.append(String.valueOf(-1) + "\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
