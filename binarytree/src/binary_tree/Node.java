package binary_tree;

public class Node {
    // data in a node
    int data;
    // left child
    Node leftChild;
    // right child
    Node rightChild;
    // represents whether a node has been deleted
    boolean isDelete;

    /**
     * Constructor
     *
     * @param data the data in a node to be created
     */
    public Node(int data) {
        this.data = data;
    }

    /**
     * Prints the data in a node.
     */
    public void display() {
        System.out.println(data);
    }
}
