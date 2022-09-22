package programmers.kakao.test2022;

import java.util.*;

public class Solution3 {

    public int[] solution(int[] fees, String[] records) {
        int[] answer = new int[4];

        Map<String, List<Map<String, Object>>> map = new HashMap<>();
        for (String record : records) {
            StringTokenizer stringTokenizer = new StringTokenizer(record);
            String time = stringTokenizer.nextToken();
            String[] strings = time.split(":");
            int hour = Integer.parseInt(strings[0]);
            int min = Integer.parseInt(strings[1]);
            int result = hour * 60 + min;
            String carNum = stringTokenizer.nextToken();
            String inAndOut = stringTokenizer.nextToken();
            List<Map<String, Object>> list;
            Map<String, Object> data = new HashMap<>();
            if (map.containsKey(carNum)) {
                list = map.get(carNum);
            } else {
                list = new ArrayList<>();
            }
            data.put("time", result);
            data.put("inAndOut", inAndOut);
            list.add(data);
            map.put(carNum, list);
        }
        int i = 0;
        for (String carNum : map.keySet()) {
            List<Map<String, Object>> mapList = map.get(carNum);
            int result = 0;
            int checkCount = 0;
            for (Map<String, Object> maps : mapList) {
                int time = (int) maps.get("time");
                String inAndOut = (String) maps.get("inAndOut");
                if (inAndOut.equals("IN")) {
                    result -= time;
                } else {
                    result += time;
                }
                checkCount++;
            }
            if (checkCount % 2 != 0) {
                result += 1439;
            }
            int result2;
            if (result > fees[0]) {
                result2 = fees[1] + ((result - 180) / 10) * 600;
            } else {
                result2 = 5000;
            }
            answer[i] = result2;
            i++;
        }
        return answer;
    }
}


