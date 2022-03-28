package baekjoon.etc;

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
            if (count >= 100) {
                return -1;
            }
            // 해당 자리에 k가 왔다면
            if (r < ints.length && c < ints[0].length) {
                if (ints[r][c] == k) {
                    return count;
                }
            }

            List<List<Integer>> list = new ArrayList<>();
            if (ints[0].length <= ints.length) {
                // 연산 R
                int rowMax = Integer.MIN_VALUE;
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
                    if (rowMax < sortAndInsert.size()) {
                        rowMax = sortAndInsert.size();
                    }
                    list.add(sortAndInsert);
                }
                int num = ints.length;
                if (rowMax > 100) {
                    rowMax = 100;
                }
                ints = new int[num][rowMax];
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
                int colMax = Integer.MIN_VALUE;
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
                    if (colMax < sortAndInsert.size()) {
                        colMax = sortAndInsert.size();
                    }
                    list.add(sortAndInsert);
                }
                int num = ints[0].length;
                if (colMax > 100) {
                    colMax = 100;
                }
                ints = new int[colMax][num];
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
            /*for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[i].length; j++) {
                    System.out.print(ints[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();*/
            count++;
        }
    }

    public static List sortAndInsert(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        List<Entry<Integer, Integer>> sortList = new ArrayList<>(map.entrySet());
        sortList.sort(Entry.comparingByValue());
        for (Entry<Integer, Integer> entry : sortList) {
            list.add(entry.getKey());
            list.add(entry.getValue());
        }
        return list;
    }
}
