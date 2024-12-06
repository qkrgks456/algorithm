package baekjoon.v1.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14891 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new int[8]);
        }
        for (int[] ints : list) {
            String s = bufferedReader.readLine();
            for (int i = 0; i < 8; i++) {
                ints[i] = s.charAt(i) - '0';
            }
        }
        // 2 인덱스랑 6 인덱스
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            // 미리 구하자 양극이 같은지 다른지
            int[] check = new int[3];
            if (list.get(0)[2] != list.get(1)[6]) {
                check[0] = 1;
            }
            if (list.get(1)[2] != list.get(2)[6]) {
                check[1] = 1;
            }
            if (list.get(2)[2] != list.get(3)[6]) {
                check[2] = 1;
            }
            if (n2 == 1) {
                // 정방향
                switch (n1) {
                    case 0:
                        if (check[0] == 1) {
                            reverse(list.get(1));
                            if (check[1] == 1) {
                                forward(list.get(2));
                                if (check[2] == 1) {
                                    reverse(list.get(3));
                                }
                            }
                        }
                        break;
                    case 1:
                        if (check[0] == 1) {
                            reverse(list.get(0));
                        }
                        if (check[1] == 1) {
                            reverse(list.get(2));
                            if (check[2] == 1) {
                                forward(list.get(3));
                            }
                        }
                        break;
                    case 2:
                        if (check[2] == 1) {
                            reverse(list.get(3));
                        }
                        if (check[1] == 1) {
                            reverse(list.get(1));
                            if (check[0] == 1) {
                                forward(list.get(0));
                            }
                        }
                        break;
                    case 3:
                        if (check[2] == 1) {
                            reverse(list.get(2));
                            if (check[1] == 1) {
                                forward(list.get(1));
                                if (check[0] == 1) {
                                    reverse(list.get(0));
                                }
                            }
                        }
                        break;
                }
                forward(list.get(n1));
            } else {
                // 역방향
                switch (n1) {
                    case 0:
                        if (check[0] == 1) {
                            forward(list.get(1));
                            if (check[1] == 1) {
                                reverse(list.get(2));
                                if (check[2] == 1) {
                                    forward(list.get(3));
                                }
                            }
                        }
                        break;
                    case 1:
                        if (check[0] == 1) {
                            forward(list.get(0));
                        }
                        if (check[1] == 1) {
                            forward(list.get(2));
                            if (check[2] == 1) {
                                reverse(list.get(3));
                            }
                        }
                        break;
                    case 2:
                        if (check[2] == 1) {
                            forward(list.get(3));
                        }
                        if (check[1] == 1) {
                            forward(list.get(1));
                            if (check[0] == 1) {
                                reverse(list.get(0));
                            }
                        }
                        break;
                    case 3:
                        if (check[2] == 1) {
                            forward(list.get(2));
                            if (check[1] == 1) {
                                reverse(list.get(1));
                                if (check[0] == 1) {
                                    forward(list.get(0));
                                }
                            }
                        }
                        break;
                }
                reverse(list.get(n1));
            }
        }

        // 마지막 결과
        int result = 0;

        if (list.get(0)[0] == 1) {
            result += 1;
        }
        if (list.get(1)[0] == 1) {
            result += 2;
        }
        if (list.get(2)[0] == 1) {
            result += 4;
        }
        if (list.get(3)[0] == 1) {
            result += 8;
        }
        System.out.println(result);
    }

    public static void reverse(int[] ints) {
        int num = ints[0];
        for (int i = 1; i < ints.length; i++) {
            ints[i - 1] = ints[i];
        }
        ints[7] = num;
    }

    public static void forward(int[] ints) {
        int num = ints[7];
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i] = ints[i - 1];
        }
        ints[0] = num;
    }
}
