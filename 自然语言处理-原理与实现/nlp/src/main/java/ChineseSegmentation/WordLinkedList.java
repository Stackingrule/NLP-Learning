package ChineseSegmentation;

public class WordLinkedList {

    class Node {

        public char element;
        public Node next;

        public Node(char item) {
            this.element = item;
            next = null;
        }
    }

    private Node root;  //记录第一个节点

    public WordLinkedList() {
        root = null;
    }

    /*
    * @descri 放入一个单词
     */
    public void add(String key) {
        if (root == null) {
            root = new Node(key.charAt(0));
        }

        Node parNode = root;   // 父节点
        for (int i = 0; i < key.length(); i++) {    //从前往后诸葛放入字符
            char ch = key.charAt(i);
            Node currNode = new Node(ch);   //当前节点
            parNode.next = currNode;        //当前节点作为父节点的字节点
            parNode = currNode;             //父节点往下移动
        }
    }

    /*
    *
     */
    public boolean find(String input) {
        Node curNode = root;    //当前节点
        int i = 0;
        while (curNode != null && i < input.length()) {
            if (curNode.element != input.charAt(i))
                return false;
            curNode = curNode.next;
            i++;
        }
        return true;    //找到
    }

    /*
    *
     */
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
        WordLinkedList wordLinkedList = new WordLinkedList();
        wordLinkedList.add("自然语言处理原理与实战");
        System.out.println(wordLinkedList.toString());
        System.out.println(wordLinkedList.find("春节快乐"));
    }

}
