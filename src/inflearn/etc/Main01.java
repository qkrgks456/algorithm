package inflearn.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main01 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Data(n1, 's'));
            list.add(new Data(n2, 'e'));
        }
        Collections.sort(list);
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (Data data : list) {
            if (data.n2 == 's') {
                count++;
            } else {
                count--;
            }
            result = Math.max(count, result);
        }
        System.out.println(result);
    }

}

class Data implements Comparable<Data> {
    int n1;
    char n2;

    public Data(int n1, char n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public int compareTo(Data o) {
        if (this.n1 != o.n1) {
            return this.n1 - o.n1;
        } else {
            return this.n2 - o.n2;
        }
    }

}
