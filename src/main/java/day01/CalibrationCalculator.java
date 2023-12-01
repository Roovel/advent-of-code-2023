package day01;

import java.util.ArrayList;

import util.NumberMap;
import util.TextUtil;

import static java.lang.Character.isLetter;

public class CalibrationCalculator {

    private final String filePath = "src/main/resources/inputs/01/input01.txt";
    TextUtil textUtil = new TextUtil(filePath);

    public CalibrationCalculator() {
        sumOfCalibrationValuesPart1();
        sumOfCalibrationValuesPart2();
    }

    private void sumOfCalibrationValuesPart1() {
        System.out.println("-----");
        System.out.println("PART 1");
        System.out.print("The sum of all of the calibration values is: ");
        System.out.println(arrayListValuePart1());
        System.out.println("-----");
    }

    private void sumOfCalibrationValuesPart2() {
        System.out.println("-----");
        System.out.println("PART 2");
        System.out.print("The sum of all of the calibration values is: ");
        System.out.println(arraylistValuePart2());
        System.out.println("-----");
    }

    private int arrayListValuePart1() {
        ArrayList<String> lines = getLines();
        int firstDigit = 0;
        int secondDigit = 0;
        int digit;
        int linesSum = 0;
        boolean gotFirstDigit = false;
        boolean gotSecondDigit = false;
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (!isLetter(line.charAt(i))) {
                    digit = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if (!gotFirstDigit) {
                        firstDigit = digit;
                        gotFirstDigit = true;
                    } else {
                        secondDigit = digit;
                        gotSecondDigit = true;
                    }
                }
            }
            if (gotSecondDigit) {
                linesSum += concatenateDigits(firstDigit, secondDigit);
            } else if (gotFirstDigit) {
                linesSum += concatenateDigits(firstDigit, firstDigit);
            }
            firstDigit = 0;
            secondDigit = 0;
            gotFirstDigit = false;
            gotSecondDigit = false;
        }
        return linesSum;
    }

    private int arraylistValuePart2() {
        boolean gotFirstDigit = false;
        boolean gotSecondDigit = false;
        int firstDigit = 0;
        int secondDigit = 0;
        int linesSum = 0;
        ArrayList<String> lines = getLines();
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                if (!isLetter(line.charAt(i))) {
                    int digit = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if (NumberMap.getNumberMap().containsValue(digit)) {
                        if (!gotFirstDigit) {
                            firstDigit = digit;
                            gotFirstDigit = true;
                        } else {
                            secondDigit = digit;
                            gotSecondDigit = true;
                        }
                    }
                }
                for (int j = i + 1; j <= line.length(); j++) {
                    String subString = line.substring(i, j);
                    if (NumberMap.getNumberMap().containsKey(subString)) {
                        if (!gotFirstDigit) {
                            firstDigit = NumberMap.getNumberMap().get(subString);
                            gotFirstDigit = true;
                        } else {
                            secondDigit = NumberMap.getNumberMap().get(subString);
                            gotSecondDigit = true;
                        }
                    }
                }
            }
            if (gotSecondDigit) {
                linesSum += concatenateDigits(firstDigit, secondDigit);
            } else if (gotFirstDigit) {
                linesSum += concatenateDigits(firstDigit, firstDigit);
            }
            firstDigit = 0;
            secondDigit = 0;
            gotFirstDigit = false;
            gotSecondDigit = false;
        }
        return linesSum;
    }

    private ArrayList<String> getLines() {
        textUtil.resetScanner(filePath);
        return textUtil.linesToArrayList();
    }

    private int concatenateDigits(int firstDigit, int secondDigit) {
        String appendedDigits = String.valueOf(firstDigit) + secondDigit;
        return Integer.parseInt(appendedDigits);
    }
}
