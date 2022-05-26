package baekjoon.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1991 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        char data = stringTokenizer.nextToken().charAt(0);
        char lt = stringTokenizer.nextToken().charAt(0);
        char rt = stringTokenizer.nextToken().charAt(0);
        Node node = new Node(data);
        node.lt = new Node(lt);
        node.rt = new Node(rt);
        for (int i = 1; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            data = stringTokenizer.nextToken().charAt(0);
            lt = stringTokenizer.nextToken().charAt(0);
            rt = stringTokenizer.nextToken().charAt(0);

        }
    }

    public static void DFS(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        DFS(root.lt);
        DFS(root.rt);
    }
}

class Node {
    char data;
    Node lt, rt;

    public Node(char data) {
        this.data = data;
        lt = rt = null;
    }
}
