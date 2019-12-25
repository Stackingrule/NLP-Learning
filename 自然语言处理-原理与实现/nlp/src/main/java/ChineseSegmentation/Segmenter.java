package ChineseSegmentation;


import java.io.BufferedReader;
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
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            read.close();   //关闭读入流
        }
    }

    //TODO
    public String nextWord() {  //得到下一个词，如果没有则返回null
        return null;
    }
}
