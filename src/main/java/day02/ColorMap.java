package day02;

import java.util.HashMap;
import java.util.Map;

public class ColorMap {

    private static final Map<String, Integer> colorMap;

    static {
        colorMap = new HashMap<>();
        colorMap.put("red", 12);
        colorMap.put("green", 13);
        colorMap.put("blue", 14);
    }

    public static Map<String, Integer> getColorMap() {
        return colorMap;
    }
}
