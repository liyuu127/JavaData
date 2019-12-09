package base.designpatterns.behavioralpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyu
 * @date 2019/12/8 16:29
 * @description
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}