package Day4;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {
        //load file
        File file = new File("src/Day4/input.txt");
        Scanner scanner = new Scanner(file);
        int cnt = 0;

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] ranges = line.split(",");
            for(String range : ranges){
                System.out.printf(range + "\t");
            }

            boolean b = checkSectionCoverage(ranges);
            if(b) cnt++;
            System.out.println(b);

        }

        System.out.println(cnt);


    }
    public static boolean checkSectionCoverage(String[] ranges) {
        String[] sectionOne = ranges[0].split("-");
        String[] sectionTwo = ranges[1].split("-");

        int min1 = Integer.parseInt(sectionOne[0]);
        int max1 = Integer.parseInt(sectionOne[1]);
        int min2 = Integer.parseInt(sectionTwo[0]);
        int max2 = Integer.parseInt(sectionTwo[1]);

        return (min1 <= min2 && max1 >= max2) || (min2 <= min1 && max2 >= max1);

    }
}

