package day01;

import java.util.HashMap;
import java.util.Map;

public class NumberMap {

    private static final Map<String, Integer> numberMap;

    static {
        numberMap = new HashMap<>();
        numberMap.put("one", 1);
        numberMap.put("two", 2);
        numberMap.put("three", 3);
        numberMap.put("four", 4);
        numberMap.put("five", 5);
        numberMap.put("six", 6);
        numberMap.put("seven", 7);
        numberMap.put("eight", 8);
        numberMap.put("nine", 9);
    }

    public static Map<String, Integer> getNumberMap() {
        return numberMap;
    }
}
