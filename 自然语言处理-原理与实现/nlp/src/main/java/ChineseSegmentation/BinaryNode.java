package ChineseSegmentation;

public class BinaryNode {
    public Comparable elemet;   //节点中的数据
    public BinaryNode left;     //左节点
    public BinaryNode right;    //右节点

    /*
    * @desc 构造方法
    */
    public BinaryNode(Comparable element) {
        this.elemet = element;
        left = right = null;
    }
}
