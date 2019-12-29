package ChineseSegmentation;

import trigramSeg.EntryWord;

public class TSTNode {
    public EntryWord data = null;

    protected TSTNode loNode;
    protected TSTNode miNode;
    protected TSTNode hiNode;

    protected char splitChar;   //本节点表示的字符

    protected String nodeValue; // 是否可以结束

    public TSTNode(char key) {
        this.splitChar = key;
    }

    public String toString() {
        return "spliterchar: " + splitChar;
    }
}
