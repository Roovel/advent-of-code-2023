package day04;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.TextUtil;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> winningSide = new ArrayList<>();
        ArrayList<String> mySide = new ArrayList<>();
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        ArrayList<Integer> myNumbers = new ArrayList<>();
        String regex = "\\b\\d{1,2}\\b";
        Pattern pattern = Pattern.compile(regex);
        TextUtil textUtil = new TextUtil("src/main/resources/inputs/04/input04.txt");
        Integer pointSum = 0;

        input = textUtil.linesToArrayList();

        for (String line : input) {
            //            System.out.println(line);

            winningSide.add(line.substring(line.indexOf(":"), line.indexOf("|")));
            mySide.add(line.substring(line.indexOf("|")));
            Matcher myNumberMatcher = pattern.matcher(mySide.get(0));
            Matcher winningNumberMatcher = pattern.matcher(winningSide.get(0));

            while (myNumberMatcher.find()) {
                Integer myNumber = Integer.valueOf(myNumberMatcher.group());
                myNumbers.add(myNumber);
            }

            while (winningNumberMatcher.find()) {
                Integer winningNumber = Integer.valueOf(winningNumberMatcher.group());
                winningNumbers.add(winningNumber);
            }
            //            System.out.println(myNumbers);
            //            System.out.println(winningNumbers);

            int points = 0;
            for (Integer myNumber : myNumbers) {
                if (winningNumbers.contains(myNumber)) {
                    if (points == 0) {
                        points = 1;
                    } else {
                        points *= 2;
                    }
                }
            }

            pointSum += points;
            points = 0;
            winningSide.clear();
            mySide.clear();
            winningNumbers.clear();
            myNumbers.clear();
        }

        System.out.println("My pile of scratchcards is worth " + pointSum + " points.");
    }
}

