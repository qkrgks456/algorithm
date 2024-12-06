package baekjoon.v1.step.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main02 {
    // 첫 번째는 Collections.sort() 를 쓰는 방법이다.
    // Collections.sort() 은 Timsort이다. Timsort 의 경우 합병 및 삽입정렬 알고리즘을 사용한다.
    // 이렇게 두 가지가 섞여있는 정렬 알고리즘을 hybrid sorting algorithm 이라고 하는데, 합병정렬(Merge Sort)의 경우
    // 최선, 최악 모두 O(nlogn)  을 보장하고. 삽입정렬(Insertion sort)의 경우 최선의 경우는 O(n) ,
    // 최악의 경우는 O(n2) 이다. 그리고 두 정렬 모두 안정 정렬(stable sort)이기 때문에
    // 즉, 합병정렬의 최악의 경우와 삽입정렬의 최선의 경우를 짬뽕한 알고리즘이 Timsort 라는 것이다.
    // 시간복잡도 O(n) ~ O(nlogn) 을 보장한다는 장점이 있다.
    // 대신에 Collections.sort()를 사용하고자 한다면 가장 쉬운 방법으로는 일반적인
    // 배열이 아닌 List 계열(ArrayList, LinkedList 등..)의 자료구조를 사용하여 정렬해야한다.
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(str); i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Collections.sort(list);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n : list) {
            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
