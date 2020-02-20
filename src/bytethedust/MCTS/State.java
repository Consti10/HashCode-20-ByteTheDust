package bytethedust.MCTS;

import bytethedust.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class State {
    private Board board;
    private int visitCount;
    private double winScore;

    public State(int nMaxLibraries, Algorithm algorithm) {
        board = new Board(nMaxLibraries, algorithm);
    }

    public State(State state) {
        //DONE: board copy constructor
        this.board = new Board(state.getBoard());
        //this.board = new Board(state.getBoard());
        this.visitCount = state.getVisitCount();
        this.winScore = state.getWinScore();
    }

    public State(Board board) {
        //DONE: board copy constructor
        this.board = new Board(board);
        //this.board = new Board(board);
    }

    Board getBoard() {
        return board;
    }

    void setBoard(Board board) {
        this.board = board;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    double getWinScore() {
        return winScore;
    }

    void setWinScore(double winScore) {
        this.winScore = winScore;
    }

    public List<State> getAllPossibleStates() {
        List<State> possibleStates = new ArrayList<>();
        //DONE: generate available Library chooses
        List<Integer> availablePositions = this.board.generatePossibleLibraries();
        for (int i = 0; i < availablePositions.size(); i++) {
            Integer p = availablePositions.get(i);
            State newState = new State(this.board);
            //DONE: correct library Index
            newState.getBoard().performMove(p);
            //newState.getBoard().performMove(newState.getPlayerNo(), p);
            possibleStates.add(newState);
        }

        return possibleStates;
    }

    void incrementVisit() {
        this.visitCount++;
    }

    void addScore(double score) {
        this.winScore += score;
    }

    void randomPlay() {
        //DONE: generate available Library chooses
        List<Integer> availablePositions = this.board.generatePossibleLibraries();
        int totalPossibilities = availablePositions.size();
        int selectRandom = (int) (Math.random() * totalPossibilities);
        this.board.performMove(availablePositions.get(selectRandom));
    }
}