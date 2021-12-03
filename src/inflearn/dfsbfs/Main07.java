package inflearn.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int data;
    Node lt, rt;

    public Node2(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main07 {
    Node root;

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    queue.add(cur.lt);
                }
                if (cur.rt != null) {
                    queue.add(cur.rt);
                }
            }
            level++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main07 tree = new Main07();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }

}
