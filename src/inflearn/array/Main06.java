package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main06 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        String[] strings = input2.split(" ");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();
        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder(s);
            list.add(stringBuilder.reverse().toString());
        }
        for (String s : list) {
            intList.add(Integer.parseInt(s));
        }
        for (int num : intList) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        boolean check = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                check = false;
            }
        }
        if (n == 1) {
            check = false;
        }
        return check;
    }
}
