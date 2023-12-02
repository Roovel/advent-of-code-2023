package day02;

import java.util.ArrayList;

import util.TextUtil;

public class Games {

    public ArrayList<String> gameList = new ArrayList<>();
    private final TextUtil textUtil = new TextUtil("src/main/resources/inputs/02/input02.txt");
    private final Colors colors = new Colors();

    public void getPart1Result() {
        System.out.println("-----");
        System.out.println("PART 1");
        System.out.println("The sum of the IDs of winning games is: " + getWonGamesIdSum());
        System.out.println("-----");
    }

    public void getPart2Result() {
        System.out.println("-----");
        System.out.println("PART 2");
        System.out.println("The sum of the power of game sets is: " + getSumOfPowers());
        System.out.println("-----");
    }

    public int getPowerOfGameSet(int gameId) {
        getGameColors(gameId);
        int power = getColorValue("red");
        power *= getColorValue("green");
        power *= getColorValue("blue");
        return power;

    }

    public int getSumOfPowers() {
        int sum = 0;
        int gameId = 1;
        for (String game : gameList) {
            sum += getPowerOfGameSet(gameId);
            gameId++;
            this.colors.clearColors();
        }
        return sum;
    }

    public int getWonGamesIdSum() {
        int sum = 0;
        int gameId = 1;
        for (String game : gameList) {
            getGameColors(gameId);
            if (compareColorValues()) {
                sum += gameId;
            }
            gameId++;
            this.colors.clearColors();
        }
        return sum;
    }

    public void generateGameList() {
        gameList = textUtil.linesToArrayList();
    }

    @Override
    public String toString() {
        return "Games{" +
                "gameList=" + gameList +
                '}';
    }

    public boolean compareColorValues() {
        return getColorValue("red") <= ColorMap.getColorMap().get("red") && getColorValue("green") <= ColorMap.getColorMap().get("green")
                && getColorValue("blue") <= ColorMap.getColorMap().get("blue");
    }

    public int getColorValue(String color) {
        int colorAmount = 0;
        try {
            switch (color) {
                case "red" -> colorAmount = colors.getHighestColorAmount(colors.getColor("red"));
                case "green" -> colorAmount = colors.getHighestColorAmount(colors.getColor("green"));
                case "blue" -> colorAmount = colors.getHighestColorAmount(colors.getColor("blue"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return colorAmount;
    }

    public void getGameColors(int gameId) {
        getGameColor(gameId, "red");
        getGameColor(gameId, "green");
        getGameColor(gameId, "blue");
    }

    public void getGameColor(int gameId, String color) {
        for (int i = 0; i < getGame(gameId).length(); i++) {
            for (int j = i + 1; j <= getGame(gameId).length(); j++) {
                if (getGame(gameId).substring(i, j).equals(color)) {
                    colors.addColor(getGame(gameId).substring(i, j), Integer.parseInt(getGame(gameId).substring(i - 3, i - 1).trim()));
                }
            }
        }
    }

    private String getGame(int Id) {
        return gameList.get(Id - 1);
    }
}

