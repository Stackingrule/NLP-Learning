package Demo;

public class FSM {

    public enum RegularWordType {
        number, //数字
        dateWord,   //日期
        email,  //邮件地址
        tel //号码
    }


    public boolean matchWorType;    //规则识别出的词类型
    public int end; //记录下次匹配开始的位置

    public boolean MatchRegularWord(String sentence, int start, int end) {
        return false;
    }

}


