package players.pathfindings.basis;

import java.util.List;

public class Node {

    private int row;
    private int column;

    private int G = 0;  // Distance to Start Node
    private int H = 0;  // Distance to Goal Node

    private Node parent;
    private List<Node> neighbours;

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int row() {
        return row;
    }
    public int column() {
        return column;
    }

    public int G() {
        return G;
    }
    public int H() {
        return H;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    public int getTotalCost() {
        return G + H;
    }

    public int getDistanceTo(Node node) {
        int deltaRow = Math.abs(node.row() - this.row);
        int deltaColumn = Math.abs(node.column() - this.column);
        return (deltaRow + deltaColumn);
    }
    
    void setDistanceToStartNode(Node previousNode) {
        this.G = previousNode.G() + this.getDistanceTo(previousNode);
    }
    
    void setDistanceToGoalNode(Node goalNode) {
        this.H = this.getDistanceTo(goalNode);
    }
    
}
