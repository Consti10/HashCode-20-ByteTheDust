package bytethedust;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static final String ASSETS_DIRECTORY="C:\\Users\\geier\\Desktop\\HashCode\\HashCode-20-ByteTheDust\\assets\\";

    public static void main(String[] args) {

        try {
            final InputDataSet inputDataset = new InputDataSet(ASSETS_DIRECTORY+"a_example.in");
            //System.out.println(inputDataset.toString());

           final OutputDataSet outputDataSet=Algorithm.generateSimpleStupidSolution(inputDataset);
           outputDataSet.writeToFile(ASSETS_DIRECTORY+"solution2.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
