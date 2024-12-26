package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main20920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        // 입력 받으면서 길이 안되면 list에 넣지 않기
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            list.add(s);
        }
        // 단어 중복 개수
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : list) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }

        List<StringPair> stringPairs = new ArrayList<>();
        for (String s : countMap.keySet()) {
            StringPair stringPair = new StringPair(s, countMap.get(s));
            stringPairs.add(stringPair);
        }

        Collections.sort(stringPairs);
        StringBuilder sb = new StringBuilder();
        for (StringPair stringPair : stringPairs) {
            sb.append(stringPair.word).append("\n");
        }
        System.out.println(sb);
    }
}

class StringPair implements Comparable<StringPair> {
    String word;
    int count;

    public StringPair(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(StringPair o) {
        if (this.count < o.count) return 1;
        if (this.count > o.count) return -1;
        if (this.word.length() < o.word.length()) return 1;
        if (this.word.length() > o.word.length()) return -1;
        return this.word.compareTo(o.word);
    }

    @Override
    public String toString() {
        return "StringPair{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
