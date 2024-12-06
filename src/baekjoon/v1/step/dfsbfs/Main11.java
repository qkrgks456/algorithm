package baekjoon.v1.step.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11 {
    static List<ArrayList<Integer>> list;
    static int[] ch;
    static int red = 1;
    static String result = "";
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            result = "YES";
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ch = new int[v + 1];
            list = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(bufferedReader.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                list.get(n1).add(n2);
                list.get(n2).add(n1);
            }
            for (int j = 1; j <= v; j++) {
                if (ch[j] == 0) {
                    if (!BFS(j)) break;
                }
            }
            System.out.println(result);
        }
    }

    public static boolean BFS(int nums) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nums);
        ch[nums] = red;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int n : list.get(num)) {
                if (ch[num] == ch[n]) {
                    result = "NO";
                    return false;
                }
                if (ch[n] == 0) {
                    ch[n] = ch[num] * -1;
                    queue.add(n);
                }
            }
        }
        return true;
    }
}
