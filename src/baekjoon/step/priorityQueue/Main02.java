package baekjoon.step.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        MinHeap minHeap = new MinHeap();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) {
                stringBuilder.append(minHeap.delete() + "\n");
            } else {
                minHeap.insert(num);
            }
        }
        System.out.println(stringBuilder);
    }
}

class MinHeap {
    public List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int num) {
        list.add(num);
        int idx = list.size() - 1;
        while (idx > 1 && list.get(idx) < list.get(idx / 2)) {
            swap(idx / 2, idx);
            idx /= 2;
        }
    }

    public int size() {
        return list.size();
    }

    public int delete() {
        if (list.size() == 1) {
            return 0;
        }
        int deleteNum = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        int idx = 1;
        while (idx * 2 < list.size()) {
            int checkIdx = idx * 2;
            if (idx * 2 + 1 < list.size() && list.get(idx * 2) > list.get(idx * 2 + 1)) {
                checkIdx = idx * 2 + 1;
            }
            if (list.get(idx) < list.get(checkIdx)) {
                break;
            } else {
                swap(idx, checkIdx);
                idx = checkIdx;
            }
        }
        return deleteNum;
    }

    public void swap(int idx1, int idx2) {
        int n = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, n);
    }
}
