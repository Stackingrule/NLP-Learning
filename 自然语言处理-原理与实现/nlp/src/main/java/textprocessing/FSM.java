package textprocessing;

public class FSM {

    static State[][] transTable = new new State[State.values.length][10];

    static {
        transTable[State.start.ordinal()][1] = State.chinese;   //按1
        transTable[State.start.ordinal()][2] = State.english;   //按·2
        transTable[State.chinese.ordinal()][0] = State.end;
        transTable[State.english.ordinal()][0] = State.end;

    }

    State current = State.start;
    State step(State s, char c) {
        return transTable[s.ordinal()][c - '0'];
    }

    public enum State {
        start,  //开始
        chinese,    //中文
        english,    //英文
        end //结束
    }

    FSM fsm = new FSM();
    System.out.println(fsm.step(fsm.current, '1'));
}
