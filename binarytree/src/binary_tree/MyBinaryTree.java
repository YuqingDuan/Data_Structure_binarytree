package binary_tree;

/**
 * This program demonstrates a binary search tree by Java.
 */
public class MyBinaryTree implements Tree {
    // root of the binary tree
    private Node root;

    @Override
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.data > key) {
                current = current.leftChild;
            } else if (current.data < key) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node current = root;
            Node parentNode = null;
            while (current != null) {
                parentNode = current;
                if (current.data > data) {
                    current = current.leftChild;
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        return true;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parentNode.rightChild = newNode;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void inOrderTraversing(Node current) {
        if (current != null) {
            inOrderTraversing(current.leftChild);
            System.out.print(current.data + " ");
            inOrderTraversing(current.rightChild);
        }
    }

    @Override
    public void preOrderTraversing(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            inOrderTraversing(current.leftChild);
            inOrderTraversing(current.rightChild);
        }
    }

    @Override
    public void postOrderTraversing(Node current) {
        if (current != null) {
            inOrderTraversing(current.leftChild);
            inOrderTraversing(current.rightChild);
            System.out.print(current.data + " ");
        }
    }

    @Override
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    @Override
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    /**
     * Deleting nodes is the most complex operation in binary search tree.
     * There are three cases of deleting nodes. The first two are relatively simple, but the third one is very complex.
     * 1. The node is a leaf node (no child node)
     * 2. The node has a child node
     * 3. The node has two children
     *
     * @param key the data stored in the node
     * @return
     */
    @Override
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        while (current.data != key) {
            parent = current;
            if (current.data > key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        // delete nodes without any children
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
        } else if (current.leftChild == null && current.rightChild != null) {// delete a node with a child node(has right child)
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.leftChild != null && current.rightChild == null) {// delete a node with a child node(has left child)
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
            return true;
        } else {// delete a node with two children
            Node successor = getSuccessor(current);
            if (current == root) {
                successor = root;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;
    }

    /**
     * Gets the successor node of the deleted node.
     *
     * @param delNode the node need to be deleted
     * @return deleted node
     */
    public Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }
}
