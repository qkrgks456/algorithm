package inflearn.stackqueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main08 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        String str2 = bufferedReader.readLine();
        String[] strings2 = str2.split(" ");
        int arrNum = Integer.parseInt(strings[0]);
        int num = Integer.parseInt(strings[1]);
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < strings2.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(Integer.parseInt(strings2[i]));
            queue.add(list);
        }
        int result = 0;
        while (true) {
            boolean check = false;
            ArrayList<Integer> list = queue.poll();
            for (int i = 0; i < queue.size(); i++) {
                ArrayList<Integer> checkList = queue.poll();
                if (list.get(1) < checkList.get(1)) {
                    check = true;
                }
                queue.add(checkList);
            }
            if (check) {
                queue.add(list);
            } else {
                result++;
                if (list.get(0) == num) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
