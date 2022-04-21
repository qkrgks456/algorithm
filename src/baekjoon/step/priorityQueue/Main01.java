package baekjoon.step.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main01 {
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

class MaxHeap {
    // 이건 나중에 영상봐야겠다
    public List<Integer> list;

    public MaxHeap() {
        list = new ArrayList<>();
        list.add(-1);
    }

    public void insert(int num) {
        list.add(num);
        int newIndex = list.size() - 1;
        while (newIndex > 1 && list.get(newIndex) > list.get(newIndex / 2)) {
            swap(newIndex / 2, newIndex);
            newIndex /= 2;
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
            int checkIdx = idx * 2; // 왼쪽 녀석 인덱스
            // 오른쪽 녀석이 있고 오른쪽 녀석이 더 크다면
            if (idx * 2 + 1 < list.size() && list.get(idx * 2) < list.get(idx * 2 + 1)) {
                checkIdx = idx * 2 + 1;
            }
            // 부모가 자식보다 크다면 멈춰 !
            if (list.get(idx) > list.get(checkIdx)) {
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
