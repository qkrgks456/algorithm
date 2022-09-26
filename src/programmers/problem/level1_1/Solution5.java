package programmers.problem.level1_1;

public class Solution5 {
    public long solution(int price, int money, int count) {
        long[] check = new long[2501];
        check[1] = price;
        for (int i = 2; i < check.length; i++) {
            check[i] = price * i;
        }
        for (int i = 2; i < check.length; i++) {
            check[i] += check[i - 1];
        }
        long num = check[count] - money < 0 ? 0 : check[count] - money;
        return num;
    }
}

// 3 6 9 12
// 3 9 18 30