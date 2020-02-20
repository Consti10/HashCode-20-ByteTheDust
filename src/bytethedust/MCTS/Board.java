package bytethedust.MCTS;

import bytethedust.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Board {
    ArrayList<Integer> libraryChoices;
    int nMaxLibraries;
    public Algorithm algorithm;

    static final int LIBRARY_CAP_REACHED = 1;
    static final int MORE_LIBRARIES_NEEDED = 0;


    public Board(int nMaxLibraries, Algorithm algorithm){
        libraryChoices = new ArrayList<>();
        this.nMaxLibraries = nMaxLibraries;
        this.algorithm = algorithm;
    }

    public Board(Board board){
        this.libraryChoices = new ArrayList<>();
        for (int i = 0; i < board.libraryChoices.size(); i++) {
            this.libraryChoices.add(board.libraryChoices.get(i));
        }
        this.nMaxLibraries = board.nMaxLibraries;
        this.algorithm = board.algorithm;
    }

    // getters and setters
    public void performMove(int libraryIndex) {
        libraryChoices.add(libraryIndex);
    }

    public int checkStatus() {
        //check if libraries have to be added
        if(algorithm.sumOfSignupTimes_biggerThanDeadline(algorithm.mapping(libraryChoices)))
            return LIBRARY_CAP_REACHED;
        return MORE_LIBRARIES_NEEDED;
    }

    public int calculateScore(){
        return algorithm.calculateScore(algorithm.mapping(this.libraryChoices));
    }

    public List<Integer> generatePossibleLibraries(){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nMaxLibraries; i++) {
            if(!libraryChoices.contains(i))
                result.add(i);
        }
        return result;
    }
}