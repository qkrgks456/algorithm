package baekjoon.step.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        AbsHeap absHeap = new AbsHeap();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) {
                stringBuilder.append(absHeap.delete() + "\n");
            } else {
                absHeap.insert(num);
            }
        }
        System.out.println(stringBuilder);
    }
}

class AbsHeap {
    private List<Integer> list;

    public AbsHeap() {
        list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int num) {
        list.add(num);
        int idx = list.size() - 1;
        while (idx > 1) {
            if (Math.abs(list.get(idx)) < Math.abs(list.get(idx / 2))) {
                swap(idx, idx / 2);
            } else if (Math.abs(list.get(idx)) == Math.abs(list.get(idx / 2))) {
                if (list.get(idx) < list.get(idx / 2)) {
                    swap(idx, idx / 2);
                }
            }
            idx /= 2;
        }
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
            if (idx * 2 + 1 < list.size() && Math.abs(list.get(idx * 2)) > Math.abs(list.get(idx * 2 + 1))) {
                checkIdx = idx * 2 + 1;
            } else if (idx * 2 + 1 < list.size() && Math.abs(list.get(idx * 2)) < Math.abs(list.get(idx * 2 + 1))) {
                checkIdx = idx * 2;
            } else if (idx * 2 + 1 < list.size()) {
                if (list.get(idx * 2) > list.get(idx * 2 + 1)) {
                    checkIdx = idx * 2 + 1;
                }
            }
            if (Math.abs(list.get(checkIdx)) > Math.abs(list.get(idx))) {
                break;
            } else if (Math.abs(list.get(checkIdx)) < Math.abs(list.get(idx))) {
                swap(checkIdx, idx);
                idx = checkIdx;
            } else {
                if (list.get(checkIdx) > list.get(idx)) {
                    break;
                } else {
                    swap(checkIdx, idx);
                    idx = checkIdx;
                }
            }
        }
        return deleteNum;
    }

    public void swap(int n1, int n2) {
        int n = list.get(n1);
        list.set(n1, list.get(n2));
        list.set(n2, n);
    }
}
