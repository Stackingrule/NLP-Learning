package SegmentInterface;

public class WordLinkedList {
    static class Node {
        char element;
        Node next;

        Node(char item) {
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

        Node praNode = root;

        for(int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node currNode = new Node(c);
            praNode.next = currNode;
            praNode = currNode;

        }
    }

    public boolean find(String input) {
        Node curNode = root;
        int i = 0;
        while (curNode != null && i < input.length()) {
            if(curNode.element != input.charAt(i))
                return false;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        Node curNode = root;

        while (curNode != null) {
            buf.append(curNode.element);
            buf.append('\t');
            curNode = curNode.next;
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        WordLinkedList c = new WordLinkedList();
        c.insert("自然语言处理");
        System.out.println(c.toString());
        System.out.println(c.find("自然语言处理"));
    }
}
