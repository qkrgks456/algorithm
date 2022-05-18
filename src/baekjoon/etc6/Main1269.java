package baekjoon.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int[] arrA = new int[A];
        Map<Integer, Integer> mapA = new HashMap<>();
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int[] arrB = new int[B];
        Map<Integer, Integer> mapB = new HashMap<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < A; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            arrA[i] = num;
            mapA.put(num, 1);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < B; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            arrB[i] = num;
            mapB.put(num, 1);
        }
        // A-B
        int aSize = mapA.size();
        for (int n : arrB) {
            if (mapA.get(n) != null) {
                aSize--;
            }
        }
        // B-A
        int bSize = mapB.size();
        for (int n : arrA) {
            if (mapB.get(n) != null) {
                bSize--;
            }
        }
        System.out.println(aSize + bSize);
    }
}
