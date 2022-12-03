package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    private static final int LOWECASE_ASCII = 'a' - 1;
    private static final int UPPERCASE_ASCII = 'A'-1 -26;
    public static void main(String[] args) throws FileNotFoundException {
        //load file
        File file = new File("src/Day3/input.txt");
        Scanner scanner = new Scanner(file);

        //assign memory
        int arrayCounter = 0, prioritySum = 0, badgeSum = 0;
        String[] array = {"", "", ""};

        //read file
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            array[arrayCounter++ % 3] = line;

            prioritySum = occurencyChecker(line.substring(0, line.length()/2), line.substring(line.length()/2), prioritySum);

            if(arrayCounter % 3 == 0) badgeSum = badgeHunter(array, badgeSum);
        }
        System.out.println(prioritySum);
        System.out.println(badgeSum);
    }

    public static int badgeHunter(String[] rucksacks, int badgeSum) {
        for(int i = 0; i < rucksacks[0].length(); i++){
            if(     rucksacks[1].contains(String.valueOf(rucksacks[0].charAt(i)))
                    && rucksacks[2].contains(String.valueOf(rucksacks[0].charAt(i)))){
                return addToSum(rucksacks[0].charAt(i), badgeSum);

            }
        }
        return badgeSum;
    }

    public static int occurencyChecker(String firstCompartment, String secondCompartment, int sum){
        for (int i = 0; i < firstCompartment.length(); i++) {
            if(secondCompartment.contains(String.valueOf(firstCompartment.charAt(i)))){
                return addToSum(firstCompartment.charAt(i), sum);
            }
        }
        return sum;
    }

    private static int addToSum(char c, int sum) {
        if(c >= 'a' && c <= 'z') return sum + (c - LOWECASE_ASCII);
        if(c >= 'A' && c <= 'Z') return sum + (c - UPPERCASE_ASCII);
        return sum;
    }

}
