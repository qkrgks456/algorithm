package programmers.problem.level2.level2_5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution6 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(String dirs) {
        Set<Check> set = new HashSet<>();
        int x = 5;
        int y = 5;
        for (String s : dirs.split("")) {
            int n = 0;
            switch (s) {
                case "U":
                    n = 0;
                    break;
                case "D":
                    n = 1;
                    break;
                case "R":
                    n = 2;
                    break;
                case "L":
                    n = 3;
                    break;
            }
            int nx = x + dx[n];
            int ny = y + dy[n];
            if (nx >= 0 && ny >= 0 && nx < 11 && ny < 11) {
                set.add(new Check(x, y, nx, ny));
                set.add(new Check(nx, ny, x, y));
                x = nx;
                y = ny;
            }
        }
        return set.size();
    }

}

class Check {
    int x;
    int y;
    int nx;
    int ny;

    public Check(int x, int y, int nx, int ny) {
        this.x = x;
        this.y = y;
        this.nx = nx;
        this.ny = ny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return (x == check.x && y == check.y && nx == check.nx && ny == check.ny)
                || (x == check.nx && y == check.ny && nx == check.x && ny == check.y);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(x, y, nx, ny);
        int hash1 = Objects.hash(nx, ny, x, y);
        return hash + hash1;
    }

    @Override
    public String toString() {
        return "Check{" +
                "x=" + x +
                ", y=" + y +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
