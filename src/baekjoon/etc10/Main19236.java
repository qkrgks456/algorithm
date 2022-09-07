package baekjoon.etc10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19236 {
    public static int[][] map; //전체 맵
    public static Fish[] fish; //물고기 정보 저장
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; //상, 상좌, 좌, 좌하, 하, 하우, 우, 상우
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        fish = new Fish[17];
        for (int i = 0; i < 4; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken()); // 물고기 번호
                int dir = Integer.parseInt(stringTokenizer.nextToken()) - 1; // 물고기 방향
                fish[num] = new Fish(num, i, j, dir, 1);
                map[i][j] = num; //map에 물고기 번호 저장
            }
        }
        Fish firstFish = fish[map[0][0]];
        firstFish.alive = 0;
        map[0][0] = -1; //상어가 있는 위치 -1
        dfs(0, 0, firstFish.dir, firstFish.num);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int sd, int eat) {
        result = Math.max(result, eat);

        //map 배열 복사
        int[][] copyMap = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, map.length);
        }

        //fish 배열 복사
        Fish[] copyFish = new Fish[fish.length];
        for (int i = 1; i <= 16; i++) {
            copyFish[i] = new Fish(fish[i].num, fish[i].x, fish[i].y, fish[i].dir, fish[i].alive);
        }

        // 물고기 이동
        moveFish();

        // 상어 이동
        for (int i = 1; i < 4; i++) { //4*4 행렬로 1칸, 2칸, 3칸까지 최대로 이동 가능
            int nx = x + dx[sd] * i;
            int ny = y + dy[sd] * i;

            //경계를 벗어나지 않고, 물고기가 없는 빈칸이 아닐 경우
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
                Fish eatFish = fish[map[nx][ny]];
                map[x][y] = 0;
                map[nx][ny] = -1;
                fish[eatFish.num].alive = 0;
                dfs(nx, ny, eatFish.dir, eat + eatFish.num);
                map[x][y] = -1;
                map[nx][ny] = eatFish.num;
                fish[eatFish.num].alive = 1; // 물고기 상태, 상어의 위치 원래대로 되돌리기
            }
        }

        // 맵 상태, 물고기 정보 되돌리기
        for (int j = 0; j < map.length; j++)
            System.arraycopy(copyMap[j], 0, map[j], 0, map.length);

        for (int i = 1; i <= 16; i++)
            fish[i] = new Fish(copyFish[i].num, copyFish[i].x, copyFish[i].y, copyFish[i].dir, copyFish[i].alive);
    }

    //물고기 이동
    public static void moveFish() {
        for (int i = 1; i <= 16; i++) { //i는 현재 물고기의 번호
            if (fish[i].alive == 0) { //죽은 물고기라면 넘김
                continue;
            }

            int dir = fish[i].dir;
            for (int j = 0; j < 8; j++) {
                dir %= 8;
                fish[i].dir = dir;
                int nx = fish[i].x + dx[dir]; //방향에 맞게 좌표 이동
                int ny = fish[i].y + dy[dir];

                //이동할 위치에 상어가 없고, 경계를 넘지 않는다면 이동 가능
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] > -1) {
                    if (map[nx][ny] == 0) { //이동할 위치가 빈칸일 경우
                        map[fish[i].x][fish[i].y] = 0; //기존 위치 빈칸으로
                    } else { //이동할 위치에 다른 물고기가 있을 경우
                        // 바꿀 물고기 위치 변경
                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[i].x;
                        fish[changeFish].y = fish[i].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;
                        //현재 물고기 위치 변경
                    }
                    fish[i].x = nx;
                    fish[i].y = ny;
                    map[nx][ny] = i;
                    break;
                }
                dir++;
            }
        }
    }
}

class Fish {
    int num;
    int x;
    int y;
    int dir;
    int alive; //0 죽음, 1 살아있음

    Fish(int num, int x, int y, int dir, int alive) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.alive = alive;
    }
}

