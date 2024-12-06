package baekjoon.v1.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16235 {
    static int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
    static int n, m, k;
    static List<Tree> list = new LinkedList<>();
    static List<Tree> dead;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ints[i], 5);
        }
        int[][] winter = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                winter[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int z = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Tree(x, y, z));
        }
        Collections.sort(list);
        // 시작
        for (int i = 0; i < k; i++) {
            // 봄
            dead = new LinkedList<>();
            Iterator<Tree> iterator = list.iterator();
            while (iterator.hasNext()) {
                Tree tree = iterator.next();
                if (ints[tree.x][tree.y] - tree.z < 0) {
                    dead.add(tree);
                    iterator.remove();
                } else {
                    ints[tree.x][tree.y] -= tree.z;
                    tree.z++;
                }
            }
            // 여름
            for (Tree tree : dead) {
                ints[tree.x][tree.y] += tree.z / 2;
            }
            // 가을
            List<Tree> babyTree = new LinkedList<>();
            for (Tree tree : list) {
                if (tree.z % 5 == 0) {
                    int nx, ny;
                    for (int l = 0; l < 8; l++) {
                        nx = tree.x + dx[l];
                        ny = tree.y + dy[l];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            babyTree.add(new Tree(nx, ny, 1));
                        }
                    }
                }
            }
            list.addAll(0, babyTree);
            // 겨울
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    ints[j][l] += winter[j][l];
                }
            }
        }
        System.out.println(list.size());
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
