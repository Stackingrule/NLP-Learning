package ChineseSpliter.data_structure;

import java.util.DuplicateFormatFlagsException;

public class BinarySearchTree {

    private class BinaryNode {
        public Comparable element;
        public BinaryNode left;
        public BinaryNode right;

        BinaryNode(Comparable element) {
            this.element = element;
            left = right = null;
        }
    }

    protected BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    protected BinaryNode insert(Comparable e, BinaryNode node) {
        if(node == null)
            node = new BinaryNode(e);
        else if(e.compareTo(node.element) < 0)
            node.left = insert(e, node.left);
        else if(e.compareTo(node.element) > 0)
            node.right = insert(e, node.right);
        else
            throw new DuplicateFormatFlagsException(e.toString());
        return node;
    }

    /**
     * 插入树
     */
    public void insert(Comparable e) {
        root = insert(e, root);
    }

    /**
     * Find an item in the tree
     * @param e the item to search for
     */
    public Comparable find(Comparable e) {
        return elementAt(find(e, root));
    }

    /**
     * Internal method to get element field
     */
    private Comparable elementAt(BinaryNode node) {
        return node == null ? null : node.element;
    }

    /**
     * Internal method to find an item in a subtree
     */
    private BinaryNode find(Comparable e, BinaryNode node) {
        while(node != null) {
            if(e.compareTo(node.element) < 0)
                node = node.left;
            else if(e.compareTo(node.element) > 0)
                node = node.right;
            else
                return node;
        }

        return null;
    }

}
