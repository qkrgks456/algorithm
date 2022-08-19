package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        for (int i = 1; i < list.size(); i++) {
            list.remove(i);
            i--;
        }
        System.out.println(list);

    }
}


class Test {
    int no;
    int num;

    public Test(int no, int num) {
        this.no = no;
        this.num = num;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Test{" +
                "no=" + no +
                ", num=" + num +
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

