package bytethedust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//TODO: modify this file for the real problem


public class OutputDataset {

    //Write the output dataset data into file
    //Input filename: filename, use absolute path

    public static void writeToFile(final String filename, final int nTypes, final ArrayList<Integer> pizzaTypes){
        StringBuilder builder=new StringBuilder();
        builder.append(nTypes).append("\n");
        for(final int val:pizzaTypes){
           builder.append(val).append(" ");
        }
        try {
            Files.write(Paths.get(filename),builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
