package programmers.problem.level1_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution2 {
    public String[] solution(String[] strings, int n) {
        List<String> result = new ArrayList<>();
        List<StringCheck> list = new ArrayList<>();
        for (String string : strings) {
            list.add(new StringCheck("" + string.charAt(n), string));
        }
        Collections.sort(list, Comparator.comparing((StringCheck o) -> o.index).thenComparing(o -> o.string));
        for (StringCheck stringCheck : list) {
            result.add(stringCheck.string);
        }
        return result.toArray(new String[result.size()]);
    }
}

class StringCheck {
    String index;
    String string;

    public StringCheck(String index, String string) {
        this.index = index;
        this.string = string;
    }

    @Override
    public String toString() {
        return "StringCheck{" +
                "index='" + index + '\'' +
                ", string='" + string + '\'' +
                '}';
    }
}
