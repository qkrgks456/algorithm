package programmers.problem.level1.level1_3;

import java.util.HashSet;

public class Solution7 {

    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() > nums.length / 2 ? nums.length / 2 : set.size();
    }
}


