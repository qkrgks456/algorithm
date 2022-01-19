package baekjoon.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int num) {
        heap.add(num);
    }

    public int delete() {
        if (heap.size() == 0) {
            return 0;
        }

        return 1;
    }

}
