package day02;

import java.util.ArrayList;

public class Colors {

    private final ArrayList<Integer> red = new ArrayList<>();
    private final ArrayList<Integer> green = new ArrayList<>();
    private final ArrayList<Integer> blue = new ArrayList<>();

    public void addColor(String color, int amount) {
        try {
            switch (color) {
                case "red" -> addRed(amount);
                case "green" -> addGreen(amount);
                case "blue" -> addBlue(amount);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getColorValue(String color) {
        int colorAmount = 0;
        try {
            switch (color) {
                case "red" -> colorAmount = getHighestColorAmount(red);
                case "green" -> colorAmount = getHighestColorAmount(green);
                case "blue" -> colorAmount = getHighestColorAmount(blue);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return colorAmount;
    }

    @Override
    public String toString() {
        return "Colors: " +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue;
    }

    private void addRed(int amount) {
        red.add(amount);
    }

    private void addGreen(int amount) {
        green.add(amount);
    }

    private void addBlue(int amount) {
        blue.add(amount);
    }

    private int getHighestColorAmount(ArrayList<Integer> color) {
        int highestEntry = 0;
        for (Integer entry : color) {
            if (entry > highestEntry) {
                highestEntry = entry;
            }
        }
        color.clear();
        color.add(highestEntry);
        return highestEntry;
    }
}
