package SegmentInterface;

public class WordLinkedList {
    class Node {
        public char element;
        public Node next;

        public Node(char item) {
            this.element = item;
            next = null;
        }
    }

    private Node root;

    public WordLinkedList() {
        root = null;
    }

    public void insert(String key) {
        if(root == null) {
            root = new Node(key.charAt(0));
        }
    }
}
