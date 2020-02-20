package bytethedust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//TODO: modify this file for the real problem

//some comments
public class OutputDataSet {

    public final int nTypes;
    public final ArrayList<Integer> pizzaTypes;

    public OutputDataSet(final int nTypes, final ArrayList<Integer> pizzaTypes){
        this.nTypes=nTypes;
        this.pizzaTypes=pizzaTypes;
    }

    //Write the output data set into a file
    //Input filename: filename, use absolute path
    public void writeToFile(final String filename){
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
