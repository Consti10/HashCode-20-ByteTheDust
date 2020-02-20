package bytethedust;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//TODO: modify this file for the real problem

public class OutputDataSet {

    public int N_LIBS;

    class XXX{
        public int id;
        public int N_BOOKS_FOR_SCANNING;
        public ArrayList<Integer> sendBooks=new ArrayList<>();
    }
    //first int is id, second int how many books
    //third to nth int: books
    public final ArrayList<XXX> xxx=new ArrayList<>();

    //Write the output data set into a file
    //Input filename: filename, use absolute path
    public void writeToFile(final String filename){
        StringBuilder builder=new StringBuilder();
        builder.append(N_LIBS).append("\n");

        for(XXX x : xxx){
            builder.append(x.id).append(" ");
            builder.append(x.N_BOOKS_FOR_SCANNING).append(" ");
            builder.append("\n");

            for(int i=0;i<x.sendBooks.size();i++){
                builder.append(x.sendBooks.get(i)).append(" ");
            }
        }

        try {
            Files.write(Paths.get(filename),builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
