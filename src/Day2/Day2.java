package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * -----------------
 * A, X = ROCK
 * B, Y = PAPER
 * C, Z  = SCISSORS
 * -----------------
 * WIN = 6
 * DRAW = 3
 * LOSE = 0
 * -----------------
 * ROCK = 1
 * PAPER = 2
 * SCISSORS = 3
 * -----------------
 */
public class Day2 {
    private static int part1 = 0;
    private static int part2 = 0;

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day2/input.txt");
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()){
            countScore(scanner.nextLine());
        }
        System.out.println("Part 1: Part 2" );
        System.out.println(part1+ ":" +part2);

    }

    public static void countScore(String line) {
        if(line.contains("A X")) {part1 += 4; part2 += 3;}
        if(line.contains("A Y")) {part1 += 8; part2 += 4;}
        if(line.contains("A Z")) {part1 += 3; part2 += 8;}
        if(line.contains("B X")) {part1 += 1; part2 += 1;}
        if(line.contains("B Y")) {part1 += 5; part2 += 5;}
        if(line.contains("B Z")) {part1 += 9; part2 += 9;}
        if(line.contains("C X")) {part1 += 7; part2 += 2;}
        if(line.contains("C Y")) {part1 += 2; part2 += 6;}
        if(line.contains("C Z")) {part1 += 6; part2 += 7;}


    }
}
