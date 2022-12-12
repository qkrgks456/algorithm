package programmers.problem.level2.level2_7;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution8 {
    public String solution(String m, String[] musicinfos) {
        List<MusicInfo> list = new ArrayList<>();
        for (String musicinfo : musicinfos) {
            MusicInfo musicInfo = new MusicInfo();
            String[] strings = musicinfo.split(",");
            musicInfo.start = LocalTime.parse(strings[0], DateTimeFormatter.ofPattern("HH:mm"));
            musicInfo.end = LocalTime.parse(strings[1], DateTimeFormatter.ofPattern("HH:mm"));
            musicInfo.name = strings[2];
            musicInfo.scale = change(strings[3]);
            musicInfo.minutes = ChronoUnit.MINUTES.between(musicInfo.start, musicInfo.end);
            list.add(musicInfo);
        }

        List<MusicInfo> musicInfoList = list.stream()
                .sorted((a, b) -> Math.toIntExact(b.minutes - a.minutes))
                .collect(Collectors.toList());

        for (MusicInfo musicInfo : musicInfoList) {
            String[] scales = musicInfo.scale.split("");
            StringBuilder stringBuilder = new StringBuilder();
            int check = 0;
            int n = 0;
            while (musicInfo.minutes != check) {
                if (n == scales.length) {
                    n = 0;
                }
                if (!scales[n].equals("#")) {
                    check++;
                }
                stringBuilder.append(scales[n]);
                n++;
            }
            if (n != scales.length && scales[n].equals("#")) stringBuilder.append("#");
            String result = stringBuilder.toString();
            if (result.contains(change(m))) return musicInfo.name;
        }
        return "(None)";
    }

    public String change(String s) {
        s = s.replaceAll("C#", "c#").replaceAll("D#", "d#")
                .replaceAll("F#", "f#").replaceAll("G#", "g#")
                .replaceAll("A#", "a#");
        return s;
    }
}

class MusicInfo {
    LocalTime start;
    LocalTime end;
    String name;
    String scale;
    long minutes;
}
