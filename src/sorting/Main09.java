package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main09 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        int n1 = Integer.parseInt(strings[0]);
        int n2 = Integer.parseInt(strings[1]);
        int[] ints = new int[n1];
        String str2 = bufferedReader.readLine();
        String[] strings1 = str2.split(" ");
        for (int i = 0; i < strings1.length; i++) {
            ints[i] = Integer.parseInt(strings1[i]);
        }
        int rt = 0;
        for (int n : ints) {
            rt += n;
        }
        int lt = ints[ints.length - 1];
        int mid = (rt + lt) / 2;
        int result = 0;
        while (lt <= rt) {
            int sum = 0;
            int count = 1;
            for (int i = 0; i < ints.length; i++) {
                if (sum + ints[i] > mid) {
                    count++;
                    sum = ints[i];
                } else {
                    sum += ints[i];
                }
            }
            if (count <= n2) {
                rt = mid - 1;
                result = mid;
                // 가능
            } else {
                lt = mid + 1;
                //불가
            }
            mid = (rt + lt) / 2;
        }
        System.out.println(result);
    }
}
