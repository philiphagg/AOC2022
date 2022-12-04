package Day4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        //load file
        File file = new File("src/Day4/input.txt");
        Scanner scanner = new Scanner(file);
        int fullCoverageOverlap = 0;
        int partialOverlap = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] ranges = line.split(",");

            boolean b = checkFullOverlap(ranges);
            boolean c = checkPartialOverlap(ranges);
            if(b) fullCoverageOverlap++;
            if(c) partialOverlap++;

        }
        System.out.println(fullCoverageOverlap);
        System.out.println(partialOverlap);
    }
    public static boolean checkFullOverlap(String[] ranges) {
        String[] sectionOne = ranges[0].split("-");
        String[] sectionTwo = ranges[1].split("-");

        int min1 = Integer.parseInt(sectionOne[0]);
        int max1 = Integer.parseInt(sectionOne[1]);
        int min2 = Integer.parseInt(sectionTwo[0]);
        int max2 = Integer.parseInt(sectionTwo[1]);

        return (min1 <= min2 && max1 >= max2) || (min2 <= min1 && max2 >= max1);

    }
    public static boolean checkPartialOverlap(String[] ranges) {
        String[] sectionOne = ranges[0].split("-");
        String[] sectionTwo = ranges[1].split("-");

        int min1 = Integer.parseInt(sectionOne[0]);
        int max1 = Integer.parseInt(sectionOne[1]);
        int min2 = Integer.parseInt(sectionTwo[0]);
        int max2 = Integer.parseInt(sectionTwo[1]);

        return (min1 <= min2 && max1 >= min2) || (min2 <= min1 && max2 >= min1);

    }
}

