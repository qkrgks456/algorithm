package programmers.problem.level2.level2_3;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class Solution2 {
    public int solution(int cacheSize, String[] cities) {
        Cache cache = new Cache(cacheSize);

        int result = 0;
        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            if (cache.containsKey(city)) {
                // hit
                result += 1;
            } else {
                // miss
                result += 5;
            }
            cache.put(city, 0);
        }
        return result;
    }
}

class Cache<String, Integer> extends LinkedHashMap<String, Integer> {
    int capacity;

    public Cache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        // eldest 가장 오랫동안 안쓴 데이터
        return super.size() > capacity;
    }
}