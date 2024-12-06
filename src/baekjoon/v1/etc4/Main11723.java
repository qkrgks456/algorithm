package baekjoon.v1.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            switch (stringTokenizer.nextToken()) {
                case "add":
                    set.add(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "check":
                    if (set.contains(Integer.parseInt(stringTokenizer.nextToken()))) {
                        stringBuilder.append(1 + "\n");
                    } else {
                        stringBuilder.append(0 + "\n");
                    }
                    break;
                case "toggle":
                    int num = Integer.parseInt(stringTokenizer.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set.addAll(list);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}
