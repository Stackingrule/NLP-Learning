package ChineseSegmentation;

import trigramSeg.EntryWord;

public class TSTNode {
    public EntryWord data = null;

    private TSTNode loNode;
    private TSTNode miNode;
    private TSTNode hiNode;

    protected char splitChar;   //本节点表示的字符

    public TSTNode(char key) {
        this.splitChar = key;
    }

    public String toString() {
        return "spliterchar: " + splitChar;
    }
}
