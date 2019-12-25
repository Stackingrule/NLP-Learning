package ChineseSegmentation;

import trigramSeg.EntryWord;

public class TernarySearchTrie {

    public static final class TSTNode {
        public EntryWord data = null;

        private TSTNode loNode;
        private TSTNode miNode;
        private TSTNode hiNode;

        public char splitChar;

        public TSTNode(char key) {
            this.splitChar = key;
        }
    }

    public TSTNode rootNode;

    public long n;  //语料库中词的数量




}
