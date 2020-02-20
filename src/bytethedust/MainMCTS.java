package bytethedust;

import bytethedust.MCTS.MonteCarloTreeSearch;

import java.io.IOException;
import java.util.List;

public class MainMCTS {

    public static final String ASSETS_DIRECTORY="D:\\Privat\\programming\\googleHashcode\\HashCode-20-ByteTheDust\\assets\\";

    public static final String[] filenames={
            "a_example", "b_read_on","c_incunabula","d_tough_choices","e_so_many_books","f_libraries_of_the_world"
    };

    public static void main(String[] args) {

        try {

            for(final String filename:filenames){
                final String path=ASSETS_DIRECTORY+"input\\"+filename+".txt";
                System.out.println("Processing"+path);

                final InputDataSet inputDataset = new InputDataSet(path);
                //System.out.println(inputDataset.toString());
                Algorithm algorithm = new Algorithm(inputDataset.libraries, inputDataset.N_DAYS_FOR_SCANNING);
                MonteCarloTreeSearch mcts = new MonteCarloTreeSearch(inputDataset.N_LIBRARIES,algorithm);
                List<Integer> result =  mcts.getBestLibraries();
                List<Schedule> schedules = algorithm.generateSchedulers(result);

                //easiest submission: no lib for scanning
                OutputDataSet outputDataSet= new OutputDataSet();
                outputDataSet.xxx = schedules;

                outputDataSet.writeToFile(ASSETS_DIRECTORY+"output\\"+filename+"_solution.txt");

            }


            //final OutputDataSet outputDataSet=Algorithm.generateSimpleStupidSolution(inputDataset);
            //outputDataSet.writeToFile(ASSETS_DIRECTORY+"solution.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
