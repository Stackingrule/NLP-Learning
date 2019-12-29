package ChineseSegmentation;


import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Segmenter {
    String text;    //切分的文本
    int offset;     //已经处理到的位置

    public Segmenter(String text) {
        this.text = text;
        offset = 0;
    }

    private static TSTNode root;

    static {//加载词典
        String fileName = "SDIC.txt";//"WordList.txt";
        try {
            //FileReader filereadnew = new FileReader(fileName);
            //BufferedReader read = new BufferedReader(filereadnew);
            FileInputStream file = new FileInputStream(fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(file, "GBK"));
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line, "\t");
                    String key = st.nextToken();

                    TSTNode currentNode = createNode(key);
                    currentNode.nodeValue = key;
                    // System.out.println(currentNode);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
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

    public static TSTNode createNode(String key) {
        int chatIndex = key.length() - 1;
        char currentChar = key.charAt(chatIndex);
        if (root == null) {
            root = new TSTNode(currentChar);
        }

        TSTNode currentNode = root;
        while (true) {
            //比较词的当前字符与节点的当前字符
            int compa = currentChar - currentNode.splitChar;
            if (compa == 0) {
                chatIndex--;    //更新位置
                if (chatIndex < 0) {    //判断是否已经到头了
                    return currentNode; //创建完毕，退出循环
                }
                currentChar = key.charAt(chatIndex);    //更新当前字符
                if (currentNode.miNode == null) {
                    currentNode.miNode= new TSTNode(currentChar);
                }
                currentNode = currentNode.miNode;   //向下找
            }
            else if (compa < 0) {
                if (currentNode.loNode == null) {
                    currentNode.loNode = new TSTNode(currentChar);  //创建左节点
                }
                currentNode = currentNode.loNode;
            }
            else {
                if (currentNode.hiNode == null) {
                    currentNode.hiNode = new TSTNode(currentChar);
                }
                currentNode = currentNode.hiNode;
            }
        }
    }
}
