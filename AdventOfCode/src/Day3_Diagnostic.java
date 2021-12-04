import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_Diagnostic {
    static File dataFile = new File("C:\\Users\\Colby\\Programming\\Java\\AdventOfCode\\d3data1");
    static ArrayList<String> dataList = new ArrayList<>();
    static ArrayList<Integer> gamma = new ArrayList<>();
    static ArrayList<Integer> epsilon = new ArrayList<>();

    static {
        try (Scanner scanner = new Scanner(new FileReader(dataFile))) {
            while (scanner.hasNext()) {
                dataList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int findModeOfPosition(int bitPosition, ArrayList<String> dataList) {
        int zeroCount = 0;
        int oneCount = 0;
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).substring(bitPosition, bitPosition+1).equals("0")) zeroCount++;
            else oneCount++;
        }
        System.out.println("There were " + zeroCount +" zeros and " + oneCount + " ones");

        if (zeroCount > oneCount) {
            gamma.add(0);
            epsilon.add(1);
            return 0;
        }
        else {
            gamma.add(1);
            epsilon.add(0);
            return 1;
        }
    }

    public static int convertListToDecimal(ArrayList<Integer> arrayList) {
        String outputString = arrayList.get(0).toString();
        for (int i = 1; i < arrayList.size(); i++) {
            outputString = outputString.concat(arrayList.get(i).toString());
        }
        System.out.println(outputString);
        return Integer.parseInt(outputString, 2);
    }

    public static int filterFindRating(ArrayList<Integer> arrayList, boolean useMax) {
        if (useMax) {

        } else {

        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < dataList.get(0).length(); i++) {
            findModeOfPosition(i, dataList);
        }
        System.out.println(gamma);
        System.out.println(epsilon);
        int gammaInt = convertListToDecimal(gamma);
        int epsilonInt = convertListToDecimal(epsilon);
        System.out.println(gammaInt * epsilonInt);
    }

}