package ChineseSegmentation;

import trigramSeg.EntryWord;

public class TSTNode {
    public EntryWord data = null;

    private TernarySearchTrie.TSTNode loNode;
    private TernarySearchTrie.TSTNode miNode;
    private TernarySearchTrie.TSTNode hiNode;

    public char splitChar;

    public TSTNode(char key) {
        this.splitChar = key;
    }
}
