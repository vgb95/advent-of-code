package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1SafePart2 {
    public static void main(String[] args) throws FileNotFoundException {


        //Create scanner to process txt file
        Scanner scanner = new Scanner(new File("input.txt"));


        int initialPosition = 50;

        int zeroCounts = 0;

        int totalNumbers = 100; // from 0 to 99

        int totalSpins = 0;
        int spinCounter = 0;


        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();


            if (line.isEmpty()) continue;

            //parsing
            char direction = line.charAt(0);
            int quant = Integer.parseInt((line.substring(1))); //no finalIndex, we need every number
            totalSpins = quant / totalNumbers;
            int remainder = quant % totalNumbers;
            spinCounter += totalSpins;
            if (direction == 'R') {
                if (initialPosition + remainder >= 100) spinCounter++;
                initialPosition = (initialPosition + remainder) % totalNumbers;
            } else if (direction == 'L') {

                if (initialPosition != 0 && initialPosition - remainder <= 0) {
                    spinCounter++;
                }

                initialPosition = initialPosition - remainder;
                while (initialPosition < 0) {
                    initialPosition += totalNumbers;
                }
            }

            System.out.println("============================");
            System.out.println(spinCounter + " 🔓");
        }
    }
}