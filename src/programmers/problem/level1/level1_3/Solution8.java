package programmers.problem.level1.level1_3;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Solution8 {
    public String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String[] dayOfWeeks = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};
        return dayOfWeeks[dayOfWeek.getValue()];
    }
}
