package baekjoon;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> list = null;
        for (String s : list) {
            System.out.println("sh");
        }
    }
}


class Test {
    int x;
    int y;

    public Test(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Test{" +
                "x=" + x +
                ", y=" + y +
                '}';
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

