package SegmentInterface;

public interface ChineseSpliter {
    /*
    *对给定的文本进行分词
    * @param text 给定的文本
    * @return 分词完毕的词组数
     */
    public String[] split(String text);
}
