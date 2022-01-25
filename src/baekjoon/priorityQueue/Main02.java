package baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        MaxHeap maxHeap = new MaxHeap();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) {
                stringBuilder.append(maxHeap.delete() + "\n");
            } else {
                maxHeap.insert(num);
            }
        }
        System.out.println(stringBuilder);
    }
}

class MinHeap {

}
