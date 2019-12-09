package base.designpatterns.behavioralpattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2019/12/8 16:23
 * @description
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
