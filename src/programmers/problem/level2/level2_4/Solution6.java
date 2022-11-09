package programmers.problem.level2.level2_4;

import java.util.*;

public class Solution6 {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : record) {
            StringTokenizer stringTokenizer = new StringTokenizer(s);
            String inOut = stringTokenizer.nextToken();
            String uid = stringTokenizer.nextToken();
            if (!inOut.equals("Leave")) {
                String nickName = stringTokenizer.nextToken();
                map.put(uid, nickName);
            }
            if (!inOut.equals("Change")) {
                list.add(inOut + " " + uid);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(list.get(i));
            String inOut = stringTokenizer.nextToken();
            String uid = stringTokenizer.nextToken();
            if (inOut.equals("Enter")) {
                answer[i] = map.get(uid) + "님이 들어왔습니다.";
            } else if (inOut.equals("Leave")) {
                answer[i] = map.get(uid) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}
