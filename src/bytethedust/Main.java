package bytethedust;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static final String ASSETS_DIRECTORY="C:\\Users\\geier\\Desktop\\HashCode\\HashCode-20-ByteTheDust\\assets\\";

    public static void main(String[] args) {
	// write your code here

        InputDataset inputDataset= null;
        try {
            inputDataset = new InputDataset(ASSETS_DIRECTORY+"a_example.in");
            System.out.println(inputDataset.toString());

            final ArrayList<Integer> solution=new ArrayList<>();
            solution.add(0);
            solution.add(2);
            solution.add(3);

            OutputDataset.writeToFile(ASSETS_DIRECTORY+"solution.txt",3,solution);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
