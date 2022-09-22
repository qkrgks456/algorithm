import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        char[] chars = {'A', 'B'};
        String[] strings = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        List<String> list = new ArrayList<>();

        int cnt = 0;
        for (String string : strings) {
            boolean check = true;
            for (char aChar : chars) {
                if (!string.contains(String.valueOf(aChar))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                cnt++;
            }
        }
        if (cnt >= 2) {

        }


    }
}
