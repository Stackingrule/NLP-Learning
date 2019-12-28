package ChineseSegmentation;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Segmenter {
    String text;    //切分的文本
    int offset;     //已经处理到的位置

    public Segmenter(String text) {
        this.text = text;
        offset = 0;
    }

    private static TSTNode root;

    static {    //加载词典
        String fileName = "WordList.txt";
        FileReader fileRead = new FileReader(fileName);
        BufferedReader read = new BufferedReader(fileRead);
        String line;    //读入的一行
        try {
            FileReader fileReader = new FileReader(fileName);
            while ((line = read.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "\t");
                String key = st.nextToken();
                TSTNode endNode = createNode(key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return.close;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }



    public String nextWord() {  //得到下一个词，如果没有则返回null

        String word = null; //候选最长词
        if (text == null || root == null) {
            return word;
        }
        if (offset >= text.length()) {  //已经·处理完毕
            return word;
        }

        TSTNode curNode = root; //从根节点开始
        int charIndex = offset; //待切分字符串的处理开始位置
        while (true) {
            if (curNode == null) {
                if (word == null) { //没有匹配上，则按照单字切分
                    word = text.substring(offset, offset + 1);
                    offset++;
                }
                return word;    //返回找到的词
            }
            int charComp = text.charAt(charIndex) - curNode.splitChar;  //比较两个字符

            if (charComp == 0) {
                charIndex++;
            }
        }
    }
}
