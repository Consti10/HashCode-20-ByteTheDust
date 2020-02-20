package bytethedust.MCTS;


import bytethedust.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MonteCarloTreeSearch {
    public static final int RUNTIMECAP = 1000;
    //private int level
    int nMaxLibraries;
    Algorithm algorithm;

    public MonteCarloTreeSearch(int nMaxLibraries, Algorithm algorithm) {
        this.nMaxLibraries = nMaxLibraries;
        this.algorithm = algorithm;

        //this.level = 3;
    }
/*
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int getMillisForCurrentLevel() {
        return 2 * (this.level - 1) + 1;
    }*/

    public Tree calculateGameTree() {
        long start = System.currentTimeMillis();
        long end = start + 60 * RUNTIMECAP;//getMillisForCurrentLevel();

        Tree tree = new Tree(nMaxLibraries, algorithm);
        Node rootNode = tree.getRoot();

        while (System.currentTimeMillis() < end) {
            // Phase 1 - Selection
            Node promisingNode = selectPromisingNode(rootNode);
            // Phase 2 - Expansion
            if (promisingNode.getState().getBoard().checkStatus() == Board.MORE_LIBRARIES_NEEDED)
                expandNode(promisingNode);

            // Phase 3 - Simulation
            Node nodeToExplore = promisingNode;
            if (promisingNode.getChildArray().size() > 0) {
                nodeToExplore = promisingNode.getRandomChildNode();
            }
            State tempState = simulateRandomPlayout(nodeToExplore);
            // Phase 4 - Update
            //DONE: score
            backPropogation(nodeToExplore, tempState.getBoard().calculateScore());
            //backPropogation(nodeToExplore, playoutResult);
        }

        //Node winnerNode = rootNode.getChildWithMaxScore();
        //tree.setRoot(winnerNode);
        return tree;
    }

    public List<Integer> getBestLibraries(){
        Tree tree = calculateGameTree();
        Node node = tree.getRoot();
        while(!node.getChildArray().isEmpty()){
           node = node.getChildWithMaxScore();
        }
        return node.getState().getBoard().libraryChoices;

    }

    private Node selectPromisingNode(Node rootNode) {
        Node node = rootNode;
        while (node.getChildArray().size() != 0) {
            node = UCT.findBestNodeWithUCT(node);
        }
        return node;
    }

    private void expandNode(Node node) {
        List<State> possibleStates = node.getState().getAllPossibleStates();
        possibleStates.forEach(state -> {
            Node newNode = new Node(state);
            newNode.setParent(node);
            node.getChildArray().add(newNode);
        });
    }

    private void backPropogation(Node nodeToExplore, int score) {
        Node tempNode = nodeToExplore;
        while (tempNode != null) {
            tempNode.getState().incrementVisit();

            tempNode.getState().addScore(score);
            //if (tempNode.getState().getPlayerNo() == playerNo)
            //    tempNode.getState().addScore(WIN_SCORE);
            tempNode = tempNode.getParent();
        }
    }

    private State simulateRandomPlayout(Node node) {
        Node tempNode = new Node(node);
        //DONE: evtl copy?
        State tempState = tempNode.getState();
        int boardStatus = tempState.getBoard().checkStatus();
/*
        if (boardStatus == opponent) {
            tempNode.getParent().getState().setWinScore(Integer.MIN_VALUE);
            return boardStatus;
        }*/
        while (boardStatus == Board.MORE_LIBRARIES_NEEDED) {
            tempState.randomPlay();
            boardStatus = tempState.getBoard().checkStatus();
        }

        return tempState;
    }

}