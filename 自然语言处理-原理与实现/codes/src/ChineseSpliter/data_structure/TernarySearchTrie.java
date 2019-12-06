package ChineseSpliter.data_structure;

public class TernarySearchTrie {

    public final class TSTNode {
        public Data data = null;
        protected TSTNode loNode;
        protected TSTNode miNode;
        protected TSTNode hiNode;

        protected char splitchar;

        protected TSTNode(char splitchar) {
            this.splitchar = splitchar;
        }

        @Override
        public String toString() {
            return "spliterchar: " + splitchar;
        }

    }

    protected TSTNode root;

    protected TSTNode getNode(String key, TSTNode startNode) {
        if(key == null) {
            return null;
        }

        int len = key.length();

        if(len == 0)
            return null;
        TSTNode currentNode = startNode;
        int charIndex = 0;
        char cmpChar = key.charAt(charIndex);
        int charComp;
        while (true) {
            if(currentNode == null) {
                return null;
            }

            charComp = cmpChar - currentNode.splitchar;
            if(charComp == 0) {
                charIndex++;
                if(charIndex == len) {
                    return currentNode;
                }
                else {
                    cmpChar = key.charAt(charIndex);
                }
                currentNode = currentNode.miNode;
            }
            else if(charComp < 0) {
                currentNode = currentNode.loNode;
            }
            else {
                currentNode = currentNode.hiNode;
            }
        }
    }

    private TSTNode addWord(String key) {
        TSTNode currentNode = root; //从根节点开始查找
        int charIndex = 0;  //从词的开头匹配
        while (true) {
            //比较词的当前字符与节点的当前字符
            int charComp = key.charAt(charIndex) - currentNode.splitchar;
            if (charComp == 0) {
                charIndex++;
                if (charIndex == key.length()) {
                    return currentNode;
                }
                if (currentNode.miNode == null) {
                    currentNode.miNode = new TSTNode(key.charAt(charIndex));
                }
                currentNode = currentNode.miNode;
            }
            else if (charComp < 0) {
                if (currentNode.loNode == null) {
                    currentNode.loNode = new TSTNode(key.charAt(charIndex));
                }
                currentNode = currentNode.loNode;
            }
            else {
                if (currentNode.hiNode == null) {
                    currentNode = new TSTNode(key.charAt(charIndex));
                }
                currentNode = currentNode.hiNode;
            }
            
        }
    }
}
