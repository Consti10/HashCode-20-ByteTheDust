package bytethedust;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    //hi consti

    public static final String ASSETS_DIRECTORY="C:\\Users\\geier\\Desktop\\HashCode\\HashCode-20-ByteTheDust\\assets\\";

    public static void main(String[] args) {

        try {
            final InputDataSet inputDataset = new InputDataSet(ASSETS_DIRECTORY+"a_example.txt");
            //System.out.println(inputDataset.toString());

            //easiest submission: no lib for scanning
            final OutputDataSet outputDataSet=new OutputDataSet();
            outputDataSet.N_LIBS=0;

            outputDataSet.writeToFile(ASSETS_DIRECTORY+"solution.txt");

           //final OutputDataSet outputDataSet=Algorithm.generateSimpleStupidSolution(inputDataset);
           //outputDataSet.writeToFile(ASSETS_DIRECTORY+"solution.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
