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

    public int getHighestColorAmount(ArrayList<Integer> color) {
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

    public ArrayList<Integer> getColor(String color) {
        ArrayList<Integer> result = new ArrayList<>();
        try {
            switch (color) {
                case "red" -> result = red;
                case "green" -> result = green;
                case "blue" -> result = blue;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public void clearColors() {
        red.clear();
        green.clear();
        blue.clear();
    }
}
