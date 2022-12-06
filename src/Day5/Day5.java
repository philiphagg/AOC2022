package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Day5/input.txt");
        Scanner scanner = new Scanner(file);

        Stack[] figure = extractFigure(scanner);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //System.out.println(line);
            String[] splittedString = line.split(" ");
            move2(figure, splittedString);
        }
        printFigure(figure);


    }

    private static void move2(Stack[] figure, String[] splittedString) {
        int amnt = Integer.parseInt(splittedString[1]);
        int fromStack = Integer.parseInt(splittedString[3]) - 1;
        int toStack = Integer.parseInt(splittedString[5]) - 1;
        LinkedList temp = new LinkedList();



        for (int i = 0; i < amnt; i++) {
            temp.addFirst(figure[fromStack].pop());
        }
        for(int i = 0; i < amnt; i++){
            figure[toStack].push(temp.pop());
        }

    }



    private static void move(Stack[] figure, String[] splittedString) {
        int amnt = Integer.parseInt(splittedString[1]);
        int fromStack = Integer.parseInt(splittedString[3]) - 1;
        int toStack = Integer.parseInt(splittedString[5]) - 1;

        for (int i = 0; i < amnt; i++) {
            Object pop = figure[fromStack].pop();
            figure[toStack].push(pop);
        }


    }

    private static Stack[] extractFigure(Scanner scanner) {
        Stack<String> rawFigure = new Stack<>();
        String line = "";
        int from = 0;
        int to = 3;
        do {
            line = scanner.nextLine();
            rawFigure.push(line);
        }
        while (!line.isEmpty());
        rawFigure.pop();

        String stackSize = rawFigure.pop();
        Stack<String>[] list = new Stack[stackSize.charAt(stackSize.length() - 1)];

        for (int i = 0; i < 9; i++) {
            list[i] = new Stack<>();
        }

        while (!rawFigure.isEmpty()) {
            String s = rawFigure.pop();
            for (int i = 0; i < 9; i++) {
                String crate = s.substring(from, to);
                if (crate.contains("[")) {
                    list[i].push(crate);
                }
                from += 4;
                to += 4;
            }
            from = 0;
            to = 3;
        }
        return list;
    }

    private static void printFigure(Stack[] figure) {
        for (int i = 0; i < 9; i++) {
            System.out.printf("%d: ", i + 1);
            System.out.println(Arrays.toString(figure[i].toArray()));
        }
    }

}
