package day03;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.TextUtil;

public class Processor {

    private ArrayList<String> engineSchematic = new ArrayList<>();
    //    private final TextUtil textUtil = new TextUtil("src/Main/resources/inputs/test");
    private final TextUtil textUtil = new TextUtil("src/main/resources/inputs/03/input03.txt");

    public void getPart1Result() {
        getEngineSchematic();
        checkNumberPerimeter(engineSchematic);
        /*System.out.println("-----");
        System.out.println("PART 1");
        System.out.println("The sum of all of the part numbers in the engine schematic is: " + sumOfPartNumbers());
        System.out.println("-----");*/
    }

    public void getPart2Result() {
        /*System.out.println("-----");
        System.out.println("PART 2");
        System.out.println("TODO");
        System.out.println("-----");*/
    }

    private void getEngineSchematic() {
        engineSchematic = textUtil.linesToArrayList();
    }

    private void checkNumberPerimeter(ArrayList<String> schematic) {
        String regex = "\\b\\d{1,3}\\b";
        Pattern pattern = Pattern.compile(regex);
        int sum = 0;
        int lineCount = 0;

        for (int i = 0; i < schematic.size(); i++) {
            Matcher matcher = pattern.matcher(schematic.get(i));
            while (matcher.find()) {
                String number = matcher.group();
                int startIndex = matcher.start();
                int endIndex = matcher.end() - 1;
                int rightIndex = matcher.end();
                int leftIndex = matcher.start() - 1;
                int diagonalStartIndex = matcher.start() - 1;
                int diagonalEndIndex = matcher.end() + 1;

                if (schematic.get(i).length() + 1 <= diagonalEndIndex) {
                    diagonalEndIndex = matcher.end();
                } else if (schematic.get(i).length() - 1 <= diagonalEndIndex) {
                    diagonalEndIndex = matcher.end() + 1;
                }

                if (diagonalStartIndex < 0) {
                    diagonalStartIndex = 0;
                }

                if (schematic.get(i).length() - 1 <= endIndex) {
                    rightIndex = endIndex;
                }

                if (leftIndex < 0) {
                    leftIndex = 0;
                }

                if (i == 0) {
                    System.out.println("First line");
                    System.out.println("Below: " + schematic.get(i + 1).substring(diagonalStartIndex, diagonalEndIndex));
                    if (schematic.get(i + 1).substring(diagonalStartIndex, diagonalEndIndex).matches("[\\d.]*") &&
                            schematic.get(i).substring(leftIndex, leftIndex + 1).matches("[\\d.]*") &&
                            schematic.get(i).substring(rightIndex, rightIndex + 1).matches("[\\d.]*")) {
                        System.out.println("is not part");
                    } else {
                        sum += Integer.parseInt(number);
                        System.out.println("is part");

                    }
                } else if (i + 1 == schematic.size()) {
                    System.out.println("Above: " + schematic.get(i - 1).substring(diagonalStartIndex, diagonalEndIndex));
                    if (schematic.get(i - 1).substring(diagonalStartIndex, diagonalEndIndex).matches("[\\d.]*") &&
                            schematic.get(i).substring(leftIndex, leftIndex + 1).matches("[\\d.]*") &&
                            schematic.get(i).substring(rightIndex, rightIndex + 1).matches("[\\d.]*")) {
                        System.out.println("is not part");
                    } else {
                        sum += Integer.parseInt(number);
                        System.out.println("is part");

                    }
                    System.out.println("Last line");
                } else {
                    System.out.println("Above: " + schematic.get(i - 1).substring(diagonalStartIndex, diagonalEndIndex));
                    System.out.println("Below: " + schematic.get(i + 1).substring(diagonalStartIndex, diagonalEndIndex));
                    if (schematic.get(i - 1).substring(diagonalStartIndex, diagonalEndIndex).matches("[\\d.]*") &&
                            schematic.get(i + 1).substring(diagonalStartIndex, diagonalEndIndex).matches("[\\d.]*") &&
                            schematic.get(i).substring(leftIndex, leftIndex + 1).matches("[\\d.]*") &&
                            schematic.get(i).substring(rightIndex, rightIndex + 1).matches("[\\d.]*")) {
                        System.out.println("is not part");
                    } else {
                        sum += Integer.parseInt(number);
                        System.out.println("is part");

                    }
                }

                System.out.println("Number: " + number);
                System.out.println("Left: " + schematic.get(i).charAt(leftIndex));
                System.out.println("Right: " + schematic.get(i).charAt(rightIndex));
            }
        }
        System.out.println(sum);
    }

    private boolean isPartNumber() {
        return true;
    }

    private void addPartNumber() {
    }

    private int sumOfPartNumbers() {
        return 0;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "engineSchematic=" + engineSchematic +
                '}';
    }
}
