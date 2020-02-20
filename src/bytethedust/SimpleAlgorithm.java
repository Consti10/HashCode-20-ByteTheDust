package bytethedust;

import java.util.ArrayList;

public class SimpleAlgorithm {

    //Stupid easy algorithm
    //For all lbraries, calculate the time it takes to sign up and scan all books.
    //If this time is smaller than the available time -> found solution , break and return
    public static OutputDataSet createSolution(final InputDataSet input){
        for(int i=0;i<input.libraries.size();i++){
            final Library library=input.libraries.get(i);
            final float time=library.getTimeToDoAll();

            System.out.println("Time for scanning:"+time);

            if(time<=input.N_DAYS_FOR_SCANNING){
                OutputDataSet outputDataSet=new OutputDataSet();
                outputDataSet.N_LIBS=1;
                outputDataSet.xxx.add(library.createScheduleAllBooks());
                return outputDataSet;
            }
        }
        //WTF there is no lib that can send all books in time.
        //Remove as many books as needed from the first lbrary
        OutputDataSet outputDataSet=new OutputDataSet();
        outputDataSet.N_LIBS=1;
        outputDataSet.xxx.add(input.libraries.get(0).createScheduleWitOneBook());
        return outputDataSet;
    }

    //slightly better.
    //In the beginning, take the library with the lowest initializaton time
    //public static OutputDataSet createSolution2(final InputDataSet input){
    //}

    public OutputDataSet createSolution(final InputDataSet input){
        final OutputDataSet output=new OutputDataSet();

        int timeLeft=input.N_DAYS_FOR_SCANNING;

        for(final Library library: input.libraries){
            timeLeft-=library.SIGNUP_TIME;
            if(timeLeft>0){
                output.N_LIBS++;
                Schedule schedule=new Schedule();
                schedule.id=library.ID;
                schedule.N_BOOKS_FOR_SCANNING=1;
                schedule.sendBooks.add(0);
                output.xxx.add(schedule);
            }
        }
        //return 
    }



    //Returns a list of indices to all libraries that can be started until signup time is over
    public static ArrayList<Library> createListOfSignupProcesses(final InputDataSet input){
        final ArrayList<Library> signup=new ArrayList<>();
        int timeLeft=input.N_DAYS_FOR_SCANNING;

        for(final Library library: input.libraries){
            timeLeft-=library.SIGNUP_TIME;
            if(timeLeft>0){
                signup.add(library);
            }
        }
        return signup;
    }




}
