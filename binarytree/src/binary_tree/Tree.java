package binary_tree;

public interface Tree {
    /**
     * Finds a node in the tree.
     *
     * @param key the data stored in the node
     * @return target node
     */
    public abstract Node find(int key);

    /**
     * Inserts a node into the tree.
     *
     * @param data the data stored in the node
     * @return insert operation is successful or not.
     */
    public abstract boolean insert(int data);

    /**
     * Inorder traversing.
     *
     * @param current start point
     */
    public abstract void inOrderTraversing(Node current);

    /**
     * Preorder traversing.
     *
     * @param current start point
     */
    public abstract void preOrderTraversing(Node current);

    /**
     * Postorder traversing.
     *
     * @param current start point
     */
    public abstract void postOrderTraversing(Node current);

    /**
     * Finds the maximum.
     *
     * @return the maximum
     */
    public abstract Node findMax();

    /**
     * Finds the minimum.
     *
     * @return the minimum
     */
    public abstract Node findMin();

    /**
     * Deletes a node.
     *
     * @param key the data stored in the node
     * @return delete operation is successful or not.
     */
    public abstract boolean delete(int key);
}
