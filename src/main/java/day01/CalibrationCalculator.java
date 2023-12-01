package day01;

import java.util.ArrayList;

import util.TextManipulation;

import static java.lang.Character.isLetter;

public class CalibrationCalculator {

    TextManipulation parseText = new TextManipulation("src/main/resources/inputs/01/input01.txt");

    public CalibrationCalculator() {
    }

    public void ArrayListValue() {
        ArrayList<String> lines = parseText.linesToArrayList();
        int firstDigit = 0;
        int secondDigit = 0;
        int digit;
        String appendedDigits;
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
                appendedDigits = String.valueOf(firstDigit) + secondDigit;
                linesSum += Integer.parseInt(appendedDigits);
            } else if (gotFirstDigit) {
                appendedDigits = String.valueOf(firstDigit) + firstDigit;
                linesSum += Integer.parseInt(appendedDigits);
            }
            firstDigit = 0;
            secondDigit = 0;
            gotFirstDigit = false;
            gotSecondDigit = false;
        }
        System.out.println(linesSum);
    }
}
