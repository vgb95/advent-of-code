package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Gifts {
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

                if (s.length() % 2 != 0) {
                    continue;
                }
                int mid = s.length()/2;
                String fHalf = s.substring(0, mid);
                String lHalf = s.substring(mid);

                if (fHalf.equals(lHalf)){
                    totalSum += j;
                }
            }
        }

        System.out.println(totalSum);


    }
}
