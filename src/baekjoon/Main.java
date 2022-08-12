package baekjoon;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.addFirst(deque.pollLast());
        System.out.println(deque);
    }
}


class Tree implements Comparable<Tree> {
    int x;
    int y;
    int z;

    public Tree(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public int compareTo(Tree t) {
        return this.z - t.z;
    }
}

