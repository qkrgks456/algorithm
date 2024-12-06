package baekjoon.v1.etc2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main13913 {
    static int N, K;
    static int check = Integer.MAX_VALUE;
    static int[] result;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        result = new int[200001];
        if (N == K) {
            System.out.println(0);
            System.out.println(N);
            System.exit(0);
        }
        BFS();
        System.out.println(check);
        find();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i) + " ");
        }
        System.out.println(stringBuilder);
    }

    // 얘도 문제가 많네, 이거 찾기 힘든디 어렵네
    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (num == K) {
                check = result[num];
                break;
            }
            int n1 = num - 1;
            int n2 = num + 1;
            int n3 = num * 2;
            if (n1 >= 0) {
                if (result[n1] == 0) {
                    result[n1] = result[num] + 1;
                    queue.add(n1);
                }
            }
            if (n2 <= 100000) {
                if (result[n2] == 0) {
                    result[n2] = result[num] + 1;
                    queue.add(n2);
                }
            }
            if (n3 <= 100000) {
                if (result[n3] == 0) {
                    result[n3] = result[num] + 1;
                    queue.add(n3);
                }
            }
        }
    }

    public static void find() {
        int num = K;
        list.add(K);
        int n1 = K - 1;
        int n2 = K + 1;
        int n3 = K / 2;
        if (n1 < 0) {
            n1 = 0;
        }
        if (n2 > 100000) {
            n2 = 0;
        }
        if (result[K] == 1) {
            list.add(N);
            return;
        }
        // 일단 한레벨 낮은애 한놈만 구하자
        if (result[n1] == result[num] - 1) {
            num = n1;
        } else if (result[n2] == result[num] - 1) {
            num = n2;
        } else if (result[n3] == result[num] - 1) {
            num = n3;
        }
        list.add(num);
        // 그다음은 지속타격
        while (true) {
            n1 = num - 1;
            n2 = num + 1;
            n3 = num / 2;
            if (result[num] - 1 == 0) break;
            if (result[n1] == result[num] - 1) {
                num = n1;
            } else if (result[n2] == result[num] - 1) {
                num = n2;
            } else if (result[n3] == result[num] - 1) {
                num = n3;
            }
            list.add(num);
        }
        list.add(N);
    }
}

