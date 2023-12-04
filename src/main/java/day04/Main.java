package day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.TextUtil;

public class Main {

    private static final Map<Integer, Integer> cardAmounts;
    static TextUtil textUtil = new TextUtil("src/main/resources/inputs/04/input04.txt");
    static ArrayList<String> input = textUtil.linesToArrayList();
    static ArrayList<String> winningSide = new ArrayList<>();
    static ArrayList<String> mySide = new ArrayList<>();
    static ArrayList<Integer> winningNumbers = new ArrayList<>();
    static ArrayList<Integer> myNumbers = new ArrayList<>();
    static String regex = "\\b\\d{1,2}\\b";
    static Pattern pattern = Pattern.compile(regex);
    static int pointSum = 0;
    private static final int initialScratchcardAmount = 1;

    public static void main(String[] args) {
        part1Solution();
        part2Solution();
    }

    private static void part1Solution() {
        for (String line : input) {
            sortNumbers(winningSide, mySide, winningNumbers, myNumbers, pattern, line);

            int points = 0;
            for (Integer myNumber : myNumbers) {
                points = getPoints(points, myNumber);
            }

            pointSum += points;
            clearUtilLists(winningSide, mySide, winningNumbers, myNumbers);
        }

        System.out.println("My pile of scratchcards is worth " + pointSum + " points.");
    }

    private static void part2Solution() {
        putScratchcardAmounts();
        int card = 1;
        int currentCard;

        for (String line : input) {
            sortNumbers(winningSide, mySide, winningNumbers, myNumbers, pattern, line);

            currentCard = card + 1;
            for (Integer myNumber : myNumbers) {
                if (winningNumbers.contains(myNumber)) {
                    setCardAmount(card, currentCard);
                    currentCard++;
                }
            }

            clearUtilLists(winningSide, mySide, winningNumbers, myNumbers);
            card++;
        }
        int sumOfValues = cardAmounts.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Ended up with " + sumOfValues + " scratchcards.");
    }

    private static void putScratchcardAmounts() {
        for (String line : input) {
            cardAmounts.put(getCardIndex(line), initialScratchcardAmount);
        }
    }

    private static int getPoints(int points, Integer myNumber) {
        if (winningNumbers.contains(myNumber)) {
            if (points == 0) {
                points = 1;
            } else {
                points *= 2;
            }
        }
        return points;
    }

    private static void sortNumbers(
            ArrayList<String> winningSide,
            ArrayList<String> mySide,
            ArrayList<Integer> winningNumbers,
            ArrayList<Integer> myNumbers,
            Pattern pattern,
            String line) {
        winningSide.add(getWinningSide(line));
        mySide.add(getMySide(line));
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
    }

    private static void setCardAmount(int card, int currentCard) {
        cardAmounts.put(currentCard, cardAmounts.get(currentCard) + (cardAmounts.get(card)));
    }

    private static void clearUtilLists(
            ArrayList<String> winningSide,
            ArrayList<String> mySide,
            ArrayList<Integer> winningNumbers,
            ArrayList<Integer> myNumbers) {
        winningSide.clear();
        mySide.clear();
        winningNumbers.clear();
        myNumbers.clear();
    }

    private static String getMySide(String line) {
        return line.substring(line.indexOf("|"));
    }

    private static String getWinningSide(String line) {
        return line.substring(line.indexOf(":"), line.indexOf("|"));
    }

    private static int getCardIndex(String line) {
        return Integer.parseInt(line.substring(line.indexOf(":") - 3, line.indexOf(":")).trim());
    }

    static {
        cardAmounts = new HashMap<>();
    }
}

