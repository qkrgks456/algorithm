package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Main07 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            boolean check = true;
            boolean nullCheck = true;
            String s = bufferedReader.readLine();
            String[] strings = s.split("");
            int num = Integer.parseInt(bufferedReader.readLine());
            String s1 = bufferedReader.readLine();
            String result = s1.substring(0, s1.length() - 1).substring(1);
            String[] strings1 = result.split(",");
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < num; j++) {
                deque.add(Integer.parseInt(strings1[j]));
            }
            for (String str : strings) {
                if (str.equals("R")) {
                    check = !check;
                } else {
                    if (!deque.isEmpty()) {
                        if (check) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    } else {
                        nullCheck = false;
                        break;
                    }
                }
            }
            if (nullCheck) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder.append("[");
                if (check) {
                    for (int n3 : deque) {
                        stringBuilder1.append(String.valueOf(n3) + ",");
                    }
                } else {
                    Iterator<Integer> iterator = deque.descendingIterator();
                    while (iterator.hasNext()) {
                        stringBuilder1.append(String.valueOf(iterator.next()) + ",");
                    }
                }
                if (!deque.isEmpty()) {
                    stringBuilder.append(stringBuilder1.substring(0, stringBuilder1.length() - 1));
                }
                stringBuilder.append("]" + "\n");
            } else {
                stringBuilder.append("error" + "\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
