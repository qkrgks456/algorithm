package baekjoon.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    // 이건 나중에 영상봐야겠다
    public List<Integer> list;

    public MaxHeap() {
        this.list = new ArrayList<>();
        list.add(0);
    }

    public void insert(int num) {
        list.add(num);
        int newIndex = list.size() - 1;
        while (newIndex > 1 && list.get(newIndex) > list.get(newIndex / 2)) {
            int n = list.get(newIndex / 2);
            list.set(newIndex / 2, newIndex);
            list.set(newIndex, n);
            newIndex /= 2;
        }
    }

    public int delete() {
        if (list.size() == 0) {
            return 0;
        }
        int delNum = list.get(1);
        return 1;
    }
}
