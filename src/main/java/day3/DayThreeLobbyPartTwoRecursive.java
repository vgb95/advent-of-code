package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreeLobbyPartTwoRecursive {
    static long maxJoltageInLine = -1;
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("empieza");
        Scanner scanner = new Scanner(new File("day3.txt"));
        long totalOutPut = 0;

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if (line.isEmpty()) continue;

            maxJoltageInLine = -1;
            searchCombs(line, 0, "");
            System.out.println("primera linea");
            totalOutPut += maxJoltageInLine;
            System.out.println("line "+maxJoltageInLine);

        }

        System.out.println(totalOutPut);

    }

    public static void searchCombs (String og, int index, String currentNb){
        if (maxJoltageInLine != -1 && currentNb.length() > 0) {
            String strRecord = String.valueOf(maxJoltageInLine);
            String prefijoRecord = strRecord.substring(0, currentNb.length());
            if (currentNb.compareTo(prefijoRecord) < 0) {
                return;
            }
        }

        if (currentNb.length() == 12){
            long value = Long.parseLong(currentNb);
            if (value > maxJoltageInLine){
                maxJoltageInLine = value;
            }
            return;
        }
        if (index == og.length()){
            return;
        }
        int charsMissed = 12-currentNb.length();
        int charAvailable = og.length()-index;
        if (charAvailable < charsMissed){
            return;
        }

        char c = og.charAt(index);
        searchCombs(og, index + 1, currentNb + c);
        searchCombs(og, index +1, currentNb);
    }
}
