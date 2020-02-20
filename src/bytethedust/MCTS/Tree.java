package bytethedust.MCTS;


import bytethedust.Algorithm;

public class Tree {
    Node root;

    public Tree(int nMaxLibraries, Algorithm algorithm) {
        root = new Node(nMaxLibraries, algorithm);
    }

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void addChild(Node parent, Node child) {
        parent.getChildArray().add(child);
    }

}