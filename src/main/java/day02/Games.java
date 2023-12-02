package day02;

import java.util.HashMap;
import java.util.Map;

public class Games {

    public Map<Integer, Boolean> gameMap = new HashMap<>();

    public void addGameResult(Integer gameId, Boolean win) {
        this.gameMap.put(gameId, win);
    }

    public int getWonGameIdSum() {
        int wonGameIdSum = 0;
        for (Map.Entry<Integer, Boolean> entry : gameMap.entrySet()) {
            if (entry.getValue().equals(true)) {
                wonGameIdSum += entry.getKey();
            }
        }
        return wonGameIdSum;
    }
}

