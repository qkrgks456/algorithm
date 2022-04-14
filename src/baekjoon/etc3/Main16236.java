package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main16236 {
    static int N, sharkSize = 2, count = 0, eat = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] ints, result;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Location> queue = new LinkedList<>();
        N = Integer.parseInt(bufferedReader.readLine());
        ints = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (ints[i][j] == 9) {
                    queue.add(new Location(i, j, 0));
                    ints[i][j] = 0;
                }
            }
        }
        // 생각을 다시 정리 해보자
        while (true) {
            result = new int[N][N];
            List<Location> fish = new ArrayList<>();
            int nx, ny;
            // 여기는 탐색
            while (!queue.isEmpty()) {
                Location location = queue.poll();
                for (int i = 0; i < 4; i++) {
                    nx = location.x + dx[i];
                    ny = location.y + dy[i];
                    // 조건에 맞는 먹을 수 있거나 지가갈 수 있는 애들만 들어온다
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && result[nx][ny] == 0 && sharkSize >= ints[nx][ny]) {
                        result[nx][ny] = result[location.x][location.y] + 1;
                        queue.add(new Location(nx, ny, result[nx][ny]));
                        // 먹을 수 있는 녀석이면 리스트로 담자
                        if (ints[nx][ny] > 0 && ints[nx][ny] < sharkSize) {
                            fish.add(new Location(nx, ny, result[nx][ny]));
                        }
                    }
                }
            }

            // 먹을 수 있는 생선이 없으면 종료
            if (fish.size() == 0) {
                System.out.println(count);
                System.exit(0);
            }

            // 생선리스트 확인
            // 맨앞 한마리 가져오기
            Location currentFish = fish.get(0);
            // 나머지 비교
            for (int i = 1; i < fish.size(); i++) {
                if (currentFish.dis > fish.get(i).dis) {
                    // 거리가 작으면
                    currentFish = fish.get(i);
                } else if (currentFish.dis == fish.get(i).dis) {
                    // 거리가 같으면
                    // 높이가 더 크면
                    if (currentFish.x > fish.get(i).x) {
                        currentFish = fish.get(i);
                    } else if (currentFish.x == fish.get(i).x) {
                        // 높이가 같으면 왼쪽부터
                        if (currentFish.y > fish.get(i).y) {
                            currentFish = fish.get(i);
                        }
                    }
                }
            }
            // 생선 먹어서 없애기
            ints[currentFish.x][currentFish.y] = 0;
            // 먹어서 증가
            eat++;
            // 자기 크기만큼 먹으면 상어 성장
            if (eat == sharkSize) {
                sharkSize++;
                eat = 0;
            }
            // 시간 추가하기
            count += currentFish.dis;
            queue.add(new Location(currentFish.x, currentFish.y, 0));
        }
    }
}

class Location {
    int x;
    int y;
    int dis;

    public Location(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
