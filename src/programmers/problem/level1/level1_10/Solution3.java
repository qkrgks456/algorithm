package programmers.problem.level1.level1_10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution3 {

    public int[] solution(String today, String[] terms, String[] privacies) {

        LocalDate todays = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        Map<String, Long> map = new HashMap<>();
        for (String term : terms) {
            StringTokenizer stringTokenizer = new StringTokenizer(term);
            String s = stringTokenizer.nextToken();
            String day = stringTokenizer.nextToken();
            map.put(s, Long.parseLong(day));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(privacies[i]);
            String day = stringTokenizer.nextToken();
            String s = stringTokenizer.nextToken();
            LocalDate localDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            Long month = map.get(s);
            LocalDate plusMonths = localDate.plusMonths(month).minusDays(1);
            if (plusMonths.getDayOfMonth() > 28) plusMonths = plusMonths.withDayOfMonth(28);
            if (todays.isAfter(plusMonths)) list.add(i + 1);
        }

        return list.stream()
                .mapToInt(o -> o)
                .toArray();
    }

}
