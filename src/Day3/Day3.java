package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    private static final int LOWECASE_ASCII = 'a' - 1;
    private static final int UPPERCASE_ASCII = 'A' - 38;
    private static int prioritySum;
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day3/input.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String line1 = scanner.nextLine();
            String compartment1 = line1.substring(0, line1.length()/2);
            String compartment2 = line1.substring(line1.length()/2);
            occurencyCecker(compartment1, compartment2);
        }
        System.out.println(prioritySum);
        System.out.println((int) 'A');
        System.out.println(UPPERCASE_ASCII);



    }
    public static void occurencyCecker(String firstCompartment, String secondCompartment){
        for (int i = 0; i < firstCompartment.length(); i++) {
            if(secondCompartment.contains(String.valueOf(firstCompartment.charAt(i)))){
                addToSum(firstCompartment, i);
                break;
            }
        }
    }

    private static void addToSum(String firstCompartment, int i) {
        if (firstCompartment.charAt(i) >= 'a'){
            prioritySum += firstCompartment.charAt(i) - LOWECASE_ASCII;
            System.out.println(firstCompartment.charAt(i)+" " +prioritySum);
        }
        else{
            prioritySum += firstCompartment.charAt(i) - UPPERCASE_ASCII;
            System.out.println(firstCompartment.charAt(i)+" " +prioritySum);
        }

    }

}
