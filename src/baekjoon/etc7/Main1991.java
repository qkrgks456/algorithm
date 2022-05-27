package baekjoon.etc7;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1991 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Tree tree = new Tree();
        for (int i = 1; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char data = stringTokenizer.nextToken().charAt(0);
            char lt = stringTokenizer.nextToken().charAt(0);
            char rt = stringTokenizer.nextToken().charAt(0);
            tree.add(data, lt, rt);
        }
        tree.DFS1(tree.root);
        System.out.println();
        tree.DFS2(tree.root);
        System.out.println();
        tree.DFS3(tree.root);
    }
}

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        this.data = val;
        lt = rt = null;
    }
}


class Tree {
    Node root;

    public void add(char data, char lt, char rt) {
        // root가 없다면 만들어 줘야지
        if (root == null) {
            if (data != '.') {
                root = new Node(data);
            }
            if (lt != '.') {
                root.lt = new Node(lt);
            }
            if (rt != '.') {
                root.rt = new Node(rt);
            }
        } else {
            search(root, data, lt, rt);
        }
    }

    // 탐색
    public void search(Node root, char data, char lt, char rt) {
        if (root == null) {
            return;
        } else if (data == root.data) {
            if (lt != '.') {
                root.lt = new Node(lt);
            }
            if (rt != '.') {
                root.rt = new Node(rt);
            }
        } else {
            search(root.lt, data, lt, rt);
            search(root.rt, data, lt, rt);
        }
    }

    public void DFS1(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print((char) root.data);
            DFS1(root.lt);
            DFS1(root.rt);
        }
    }

    public void DFS2(Node root) {
        if (root == null) {
            return;
        } else {
            DFS2(root.lt);
            System.out.print((char) root.data);
            DFS2(root.rt);
        }
    }

    public void DFS3(Node root) {
        if (root == null) {
            return;
        } else {
            DFS3(root.lt);
            DFS3(root.rt);
            System.out.print((char) root.data);
        }
    }
}
