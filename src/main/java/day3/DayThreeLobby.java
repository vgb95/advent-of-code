package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreeLobby {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("day3.txt"));

        long totalOutPut = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.isEmpty()) continue;

            int maxJoltage = -1;

            for (int i = 0; i < line.length()-1; i++) {
                for (int j = i+1; j < line.length(); j++) {

                    String str1 = String.valueOf(line.charAt(i));
                    String str2 = String.valueOf(line.charAt(j));

                    String truncatedChars = str1+str2;
                    int joltCheck = Integer.parseInt(truncatedChars);

                    if (joltCheck > maxJoltage){
                        maxJoltage = joltCheck;
                    }

                }

            }
            totalOutPut += maxJoltage;

        }

        System.out.println(totalOutPut);

    }
}
