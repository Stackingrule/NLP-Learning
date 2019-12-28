package ChineseSegmentation;

public class BinarySearchTree {
    protected BinaryNode root;  //根节点

    /*
    * @desc 构造树
     */
    public BinarySearchTree() {
        root = null;
    }


    /*
    * @desc 插入子树的内部方法
     */
    protected BinaryNode insert(Comparable e, BinaryNode node) {
        if (node == null)
            node = new BinaryNode(e);
        else if (e.compareTo(node.elemet) < 0) {
            node.left = insert(e, node.left);
        }
        else if (e.compareTo(node.elemet) > 0) {
            node.right = insert(e, node.right);
        }
        else
            throw new DuplicateItemException(e.toString());
        return node;
    }

    /*
    * 插入树
    * @param x the item to insert
    * @
     */
    public void insert(Comparable e) {
        root = insert(e, root);
    }

    /*
    *Find an item in the tree
     */
    public Comparable find(Comparable e) {
        return elementAt(find(e, root));
    }

    /*
    * Internal method to get element in a tree
     */
    private Comparable elementAt(BinaryNode node) {
        return node == null ? null : node.elemet;
    }

    /*
    *nternal method to find an item in a subtree
     */
    private BinaryNode find(Comparable e, BinaryNode node) {
        while (node != null) {
            if (e.compareTo(node.elemet) < 0) {
                node = node.left;
            }
            else if(e.compareTo(node.elemet) > 0) {
                node = node.right;
            }
            else {
                return node;    //matched
            }
        }
        return null;
    }

}
