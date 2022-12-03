package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day1/input.txt");
        Scanner scanner = new Scanner(file);

        int[] array = {0, 0, 0};

        int highest = 0;
        int sum = 0;


        while (scanner.hasNextLine()) {

            String line = scanner.nextLine()
                    .stripLeading()
                    .stripTrailing();

            if (line.isEmpty()) {
                highest = Math.max(sum, highest);
                if (sum > min(array)) {
                    array = replace(array, min(array), sum);
                }

                sum = 0;
                continue;
            }
            sum += Integer.parseInt(line);

        }
        System.out.println("highest: " + highest);
        System.out.println("top three elves carry: " + sum(array));
    }

    public static int min(int[] arr) {


        return Math.min(arr[0], Math.min(arr[1], arr[2]));
    }
    public static int[] replace(int[] arr, int old, int newNum) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = newNum;
                break;
            }
        }
    return arr;
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}