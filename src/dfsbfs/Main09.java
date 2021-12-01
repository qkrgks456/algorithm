package dfsbfs;

class Node3 {
    int data;
    Node3 lt, rt;

    Node3(int data) {
        this.data = data;
        lt = rt = null;
    }
}

public class Main09 {
    Node3 root;

    public static int DFS(int n, Node3 root) {
        if (root.lt == null && root.rt == null) {
            return n;
        } else {
            return Math.min(DFS(n + 1, root.lt), DFS(n + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        Main09 main09 = new Main09();
        main09.root = new Node3(1);
        main09.root.lt = new Node3(2);
        main09.root.rt = new Node3(3);
        main09.root.lt.lt = new Node3(4);
        main09.root.lt.rt = new Node3(5);
        System.out.println(DFS(0, main09.root));
    }
}
