package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class Main17140 {
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int r = Integer.parseInt(strings[0]) - 1;
        int c = Integer.parseInt(strings[1]) - 1;
        int k = Integer.parseInt(strings[2]);
        ints = new int[3][3];
        for (int i = 0; i < 3; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                ints[i][j] = Integer.parseInt(strings1[j]);
            }
        }
        System.out.println(cul(r, c, k));
    }

    public static int cul(int r, int c, int k) {
        int count = 0;
        while (true) {
            // 100번 넘으면
            if (count > 100) {
                return -1;
            }
            // 해당 자리에 k가 왔다면
            if (r < ints.length && c < ints[0].length) {
                if (ints[r][c] == k) {
                    return count;
                }
            }

            List<List<Integer>> list = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            if (ints[0].length <= ints.length) {
                // 연산 R
                for (int i = 0; i < ints.length; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < ints[i].length; j++) {
                        if (ints[i][j] == 0) continue;
                        Integer data = map.get(ints[i][j]);
                        if (data == null) {
                            map.put(ints[i][j], 1);
                        } else {
                            map.put(ints[i][j], data + 1);
                        }
                    }
                    List sortAndInsert = sortAndInsert(map);
                    if (max < sortAndInsert.size()) {
                        max = sortAndInsert.size();
                    }
                    list.add(sortAndInsert);
                }
                int num = ints.length;
                int num2 = ints[0].length;
                if (max > 100) {
                    max = 100;
                } else if (max < num2) {
                    max = num2;
                }
                ints = new int[num][max];
                for (int i = 0; i < num; i++) {
                    List<Integer> integers = list.get(i);
                    int size = integers.size();
                    if (size > 100) {
                        size = 100;
                    }
                    for (int j = 0; j < size; j++) {
                        ints[i][j] = integers.get(j);
                    }
                }
            } else {
                // 연산 C
                for (int i = 0; i < ints[0].length; i++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j][i] == 0) continue;
                        Integer data = map.get(ints[j][i]);
                        if (data == null) {
                            map.put(ints[j][i], 1);
                        } else {
                            map.put(ints[j][i], data + 1);
                        }
                    }
                    List sortAndInsert = sortAndInsert(map);
                    if (max < sortAndInsert.size()) {
                        max = sortAndInsert.size();
                    }
                    list.add(sortAndInsert);
                }
                int num = ints[0].length;
                int num2 = ints.length;
                if (max > 100) {
                    max = 100;
                } else if (max < num2) {
                    max = num2;
                }
                ints = new int[max][num];
                for (int i = 0; i < num; i++) {
                    List<Integer> integers = list.get(i);
                    int size = integers.size();
                    if (size > 100) {
                        size = 100;
                    }
                    for (int j = 0; j < size; j++) {
                        ints[j][i] = integers.get(j);
                    }
                }
            }
            count++;
        }
    }

    public static List sortAndInsert(Map<Integer, Integer> map) {
        List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        List<Integer> result = new ArrayList<>();
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o1.getKey().compareTo(o2.getKey());
            else
                return o1.getValue().compareTo(o2.getValue());
        });
        for (Entry<Integer, Integer> entry : list) {
            result.add(entry.getKey());
            result.add(entry.getValue());
        }
        return result;
    }
}
