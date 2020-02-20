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
public class InputDataSet {

    public final int N_BOOKS;
    public final int N_LIBRARIES;
    public final int N_DAYS_FOR_SCANNING;
    public final ArrayList<Integer> scoresForBooks=new ArrayList<>();

    public final ArrayList<Library> libraries=new ArrayList<>();

    public class Library{
        int N_BOOKS;
        int SIGNUP_TIME;
        int SHIPPED_BOOKS_PER_DAY;
        ArrayList<Integer> books=new ArrayList<>();
    }

    //All members should be immutable (it makes no sense to alter the input data set)
    //since they are immutable, make them public and avoid getters / setters

    //Construct a Input data set java instance from the provided filename
    InputDataSet(final String filename) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            final String firstLine=br.readLine();
            assert firstLine != null;
            final String[] firstLineData=firstLine.split(" ");
            N_BOOKS=Integer.parseInt(firstLineData[0]);
            N_LIBRARIES=Integer.parseInt(firstLineData[1]);
            N_DAYS_FOR_SCANNING=Integer.parseInt(firstLineData[2]);

            final String secondLine=br.readLine();
            assert secondLine!=null;
            final String[] secondLineData=secondLine.split(" ");
            for(int i=0;i<secondLineData.length;i++){
                final int value=Integer.parseInt(secondLineData[i]);
                scoresForBooks.add(value);
            }

            for(int i=0;i<N_LIBRARIES;i++){
                Library library=new Library();
                final String line1=br.readLine();
                final String[] line1Data=line1.split(" ");
                library.N_BOOKS=Integer.parseInt(line1Data[0]);
                library.SIGNUP_TIME=Integer.parseInt(line1Data[1]);
                library.SHIPPED_BOOKS_PER_DAY=Integer.parseInt(line1Data[2]);

                final String line2=br.readLine();
                final String[] line2Data=line1.split(" ");
                for(int y=0;y<line2Data.length;y++){
                    final int value=Integer.parseInt(line2Data[i]);
                    library.books.add(value);
                }
                libraries.add(library);
            }
        }
        assert libraries.size()==N_LIBRARIES;
    }

    //For testing/ debugging
    @Override
    public String toString(){
        StringBuilder builder=new StringBuilder();
        /*for(final int val:pizzas){
            builder.append(val);
            builder.append("\n");
        }*/
        return builder.toString();
    }

    public void createSolution(){
        //
    }


}
