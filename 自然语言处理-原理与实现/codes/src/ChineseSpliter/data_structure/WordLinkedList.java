package ChineseSpliter.data_structure;

public class WordLinkedList {

    private class Node {
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

    public void add(String key) {
        if(root == null) {
            root = new Node(key.charAt(0));
        }

        Node preNode = root;
        for(int i = 1; i < key.length(); i++) {
            char  c = key.charAt(i);
            Node currNode = new Node(c);
            preNode.next = currNode;
            preNode = currNode;
        }
    }

    public boolean find(String input) {
        Node currNode = root;
        int i = 0;
        while(currNode != null && i < input.length()) {
            if(currNode.element != input.charAt(i))
                return false;
            currNode = currNode.next;
            i++;
        }
        return true;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();

        Node currNode = root;

        while(currNode != null) {
            buf.append(currNode.element);
            buf.append('\t');
            currNode = currNode.next;
        }

        return buf.toString();

    }

    public static void main(String[] args) {
        WordLinkedList c = new WordLinkedList();
        c.add("春节快乐");
        System.out.println(c.toString());
        System.out.println(c.find("春节快乐"));
        System.out.println(c.find("自然语言处理入门"));
    }
}
