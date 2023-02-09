package inflearn.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<DatePay> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new DatePay(m, d));
            max = Math.max(max, d);
        }
        list.sort(Collections.reverseOrder());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int idx = 0;
        for (int i = max; i >= 1; i--) {
            while (i <= list.get(idx).day) {
                priorityQueue.add(list.get(idx).pay);
                idx++;
                if (idx == list.size()) break;
            }
            if (!priorityQueue.isEmpty()) result += priorityQueue.poll();
        }
        System.out.println(result);
    }
}

class DatePay implements Comparable<DatePay> {
    int pay;
    int day;

    public DatePay(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(DatePay o) {
        if (this.day == o.day) {
            return this.pay - o.pay;
        }
        return this.day - o.day;
    }

    @Override
    public String toString() {
        return "DatePay{" +
                "pay=" + pay +
                ", day=" + day +
                '}';
    }
}

