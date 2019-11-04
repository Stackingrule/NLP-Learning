package SegmentInterface;
import SegmentInterface.ChineseSpliter;

import java.util.List;

public class Segementer {
    private String text;
    public void Segementer(String text) {
        this.text = text;

    }
    Segementer seg = new Segementer("自然语言处理原理与实践");
    List<String> result = seg.split();
    for(String word:result) {
        System.out.println(word);
    }
}
