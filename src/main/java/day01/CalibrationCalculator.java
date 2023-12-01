package day01;

import java.util.ArrayList;

import util.TextUtil;

import static java.lang.Character.isLetter;

public class CalibrationCalculator {

    TextUtil textUtil = new TextUtil("src/main/resources/inputs/01/input01.txt");

    public CalibrationCalculator() {
    }

    public void sumOfCalibrationValuesPart1() {
        System.out.println("-----");
        System.out.println("Part 1");
        System.out.print("The sum of all of the calibration values is: ");
        System.out.println(arrayListValuePart1());
        System.out.println("-----");
    }

    public void sumOfCalibrationValuesPart2() {
        System.out.println("-----");
        System.out.println("Part 2");
        System.out.print("The sum of all of the calibration values is: ");
        System.out.println("TODO");
        System.out.println("-----");
    }

    private int arrayListValuePart1() {
        ArrayList<String> lines = textUtil.linesToArrayList();
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

    private int concatenateDigits(int firstDigit, int secondDigit) {
        String appendedDigits = String.valueOf(firstDigit) + secondDigit;
        return Integer.parseInt(appendedDigits);
    }
}
