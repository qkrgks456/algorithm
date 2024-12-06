package baekjoon.v2.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main9655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) {
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }
}
