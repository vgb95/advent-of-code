package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2GiftsPartTwo {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("day2.txt"));

        String giantLine = scanner.nextLine();
        String[] range = giantLine.split(",");
        long totalSum = 0;

        for (int i = 0; i < range.length; i++) {
            System.out.println(range[i]);

         String[] subRange = range[i].split("-");
            long start = Long.parseLong(subRange[0]);
            long end = Long.parseLong(subRange[1]);

            for (long j = start; j <= end; j++) {

                String s = String.valueOf(j);
                int len = s.length();

                for (int k = 1; k <= len / 2 ; k++){

                    if (len % k != 0){
                        continue;
                    }

                    String pattern = s.substring(0,k);
                    int reps = len/k;

                    StringBuilder sb = new StringBuilder();

                    for (int m = 0; m < reps; m++) {
                        sb.append(pattern);
                    }

                    if (sb.toString().equals(s)){
                        totalSum += j;
                        break;
                    }
                }

            }
        }

        System.out.println(totalSum);


    }
}
