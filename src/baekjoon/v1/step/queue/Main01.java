package baekjoon.v1.step.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            if (s.contains("push")) {
                String[] strings = s.split(" ");
                list.add(Integer.parseInt(strings[1]));
            } else if (s.equals("pop")) {
                if (!list.isEmpty()) {
                    bufferedWriter.write(String.valueOf(list.get(0)) + "\n");
                    list.remove(0);
                } else {
                    bufferedWriter.write(-1 + "\n");
                }
            } else if (s.equals("size")) {
                bufferedWriter.write(String.valueOf(list.size()) + "\n");
            } else if (s.equals("empty")) {
                if (!list.isEmpty()) {
                    bufferedWriter.write(0 + "\n");
                } else {
                    bufferedWriter.write(1 + "\n");
                }
            } else if (s.equals("front")) {
                if (!list.isEmpty()) {
                    bufferedWriter.write(String.valueOf(list.get(0)) + "\n");
                } else {
                    bufferedWriter.write(-1 + "\n");
                }
            } else if (s.equals("back")) {
                if (!list.isEmpty()) {
                    bufferedWriter.write(String.valueOf(list.get(list.size() - 1)) + "\n");
                } else {
                    bufferedWriter.write(-1 + "\n");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
