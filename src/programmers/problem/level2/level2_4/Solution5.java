package programmers.problem.level2.level2_4;

import java.util.ArrayList;

public class Solution5 {
    public int solution(int[] scoville, int K) {
        MinHeap heap = new MinHeap();
        for (int n : scoville) {
            heap.insert(n);
        }
        int result = 0;
        while (true) {
            result++;
            int n1 = heap.delete();
            int n2 = heap.delete();
            int check = n1 + n2 * 2;
            heap.insert(check);
            if (heap.sucCheck(K)) return result;
            if (heap.failCheck(K)) return -1;
        }
    }
}

class MinHeap {
    private ArrayList<Integer> heap;

    //최소힙 생성자
    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0); // 0번째 인덱스는 사용 안합
    }

    //삽입
    public void insert(int val) {
        heap.add(val);
        int p = heap.size() - 1;    //p는 새로 삽입한 노드의 인덱스 정보
        while (p > 1 && heap.get(p / 2) > heap.get(p)) {
            //새로 삽입한 노드의 위치가 1 초과이고 부모가 자식보다 크면 진행 ->새로 삽입한 노드의 위치가 루트까지 가거나 새로 삽입한 노드가 부모보다 클때까지 진행
            int tmp = heap.get(p / 2);//부모 노드의 값
            heap.set(p / 2, val);
            heap.set(p, tmp);
            p /= 2;    //새로 삽입한 노드가 한 레벨 상승했으니 인덱스 부모 노드 인덱스 값으로 변경
        }
    }

    //삭제
    public int delete() {
        //힙 이 비어있으면 0리턴
        if (heap.size() - 1 < 1) {
            return 0;
        }

        //삭제할 노드, 루트 노드
        int deleteitem = heap.get(1);

        //마지막 노드를root에 삽입하고 마지막 노드 삭제
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1; //루트에 새로 삽입한 노드의 인덱스 정보

        //pos*2는 왼쪽자식의 인덱스 값, 자식의 인덱스 값이 힙의 사이즈 값보다 크다는것은 더이상 삽입할 위치를 벗어났다는뜻
        while ((pos * 2) < heap.size()) {
            int min = heap.get(pos * 2);//왼쪽 자식의 값
            int minPos = pos * 2;// 왼쪽 자식의 인덱스 값

            //오른쪽 자식의 인덱스가 사이즈보다 작고 왼쪽 보다 더 작을때 오른쪽 자식을 부모와 바꿔줄 자식으로 지정
            if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
                min = heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            //부모가 더 작으면 그만
            if (min > heap.get(pos)) break;

            //부모 자식 교환
            int tmp = heap.get(pos);
            heap.set(pos, heap.get(minPos));
            heap.set(minPos, tmp);
            pos = minPos;
        }

        return deleteitem;
    }

    public boolean sucCheck(int k) {
        if (heap.get(1) >= k) {
            return true;
        }
        return false;
    }

    public boolean failCheck(int k) {
        if (heap.size() == 2) {
            if (heap.get(1) < k) {
                return true;
            }
        }
        return false;
    }

}