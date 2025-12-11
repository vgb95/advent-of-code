package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1Safe {
    public static void main(String[] args) throws FileNotFoundException {


        //Create scanner to process txt file
        Scanner scanner = new Scanner(new File("input.txt"));

        // save initial position
        int initialPosition = 50;
        // counter times zero
        int zeroCounts = 0;
        // total numbers
        int totalNumbers = 100; // from 0 to 99

        // line processing
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();

            //if there is empty lines at the end, we skip them
            if (line.isEmpty()) continue;

            //parsing
            char direction = line.charAt(0);
            int quant = Integer.parseInt((line.substring(1))); //no finalIndex, we need every number

            if (direction == 'R') {
                initialPosition = (initialPosition+quant) % totalNumbers;
            } else if (direction == 'L') {

                initialPosition = initialPosition - quant;

                //if a number is negative we add 100 and then proceed
                while (initialPosition < 0) {
                    initialPosition = initialPosition + totalNumbers;
                }
                //assure just in case
                initialPosition = initialPosition % totalNumbers;
            }

            if (initialPosition == 0) {
                zeroCounts++;
                //just for visual pleasure
                System.out.println("CLICK ⭐️ new 0 found  " + line);
            }
        }

        System.out.println("============================");
        System.out.println(zeroCounts + " 🔓");
    }
}
