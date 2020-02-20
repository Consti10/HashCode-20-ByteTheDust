package bytethedust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//Parsing the input file into a proper representation as java class is always similar
//At the time,the class reads the practice problem. First step will be:
//TODO modify this file for the real problem

@SuppressWarnings("WeakerAccess")
public class InputDataset {
    //All members should be immutable (it makes no sense to alter the input data set)
    final int maxSlices;
    final int nPizzas;
    final ArrayList<Integer> pizzas=new ArrayList<>();

    //Construct a Input data set java instance from the provided filename
    InputDataset(final String filename) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String firstLine=br.readLine();
            assert firstLine != null;
            final String[] firstLineData=firstLine.split(" ");
            maxSlices=Integer.parseInt(firstLineData[0]);
            nPizzas=Integer.parseInt(firstLineData[1]);
            //Now to the pizzas
            final String secondLine=br.readLine();
            assert secondLine!=null;
            final String[] secondLineData=secondLine.split(" ");
            assert secondLineData.length==nPizzas;

            for(int i=0;i<secondLineData.length;i++){
                final int value=Integer.parseInt(secondLineData[i]);
                pizzas.add(value);
            }
        }
    }

    //For testing/ debugging
    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        for(final int val:pizzas){
            builder.append(val);
            builder.append("\n");
        }
        return builder.toString();
    }


}
